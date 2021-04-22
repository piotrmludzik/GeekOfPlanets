package com.codecool.geekofplanets.game.logic;

import com.codecool.geekofplanets.game.controller.GameController;
import com.codecool.geekofplanets.world.universe.Field;
import com.codecool.geekofplanets.world.universe.GameBoard;
import com.codecool.geekofplanets.world.universe.actors.Player;
import com.codecool.geekofplanets.world.universe.objects.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConstants;
import java.util.LinkedList;
import java.util.List;

@Component
public class GameLogic {
    private final GameController gameController;
    private final GameBoard gameBoard;
    private final List<Player> players = new LinkedList<>();

    @Autowired
    public GameLogic(@Lazy GameController gameController, GameBoard gameBoard) {
        this.gameController = gameController;
        this.gameBoard = gameBoard;
    }

    public Player createPlayer(String name) {
        Planet planet = gameBoard.getEmptyPlanet();
        Player player = new Player(planet);
        player.setName(name);
        Field field = planet.getField();
        player.setField(field);
        players.add(player);
        return player;
    }

    public void movePlayer(Player player, Direction direction) {
        Field actualField = player.getField();
        Field destinationCoordinates = new Field(
                actualField.getX() + direction.getCoordinates().getX(),
                actualField.getY() + direction.getCoordinates().getY());
        player.setField(destinationCoordinates);
        actualField.clearField();
    }

    public List<Field> getFieldsInView(Player player) {
        List<Field> fieldsInView = new LinkedList<>();
        Field playerPosition = player.getField();
        int playerRadius = player.getStatistics().getRadius();

        for (int x = playerPosition.getX() - playerRadius; x <= playerPosition.getX() + playerRadius; x++) {
            for (int y = playerPosition.getY() - playerRadius; y <= playerPosition.getY() + playerRadius; y++) {
                if (!isOutOfBounds(x,y))
                    fieldsInView.add(gameBoard.getField(x, y));
            }
        }

        return fieldsInView;
    }

    private boolean isOutOfBounds(int x, int y){
        if (x < 0 || y < 0)
            return true;
        if (x > gameBoard.getWidth() || y > gameBoard.getHeight())
            return true;
        return false;
    }
}
