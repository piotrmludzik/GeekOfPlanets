package com.codecool.geekofplanets.game.logic;

import com.codecool.geekofplanets.game.controller.GameController;
import com.codecool.geekofplanets.world.universe.Field;
import com.codecool.geekofplanets.world.universe.GameBoard;
import com.codecool.geekofplanets.world.universe.actors.Player;
import com.codecool.geekofplanets.world.universe.objects.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class GameLogic {
    private final GameController gameController;
    private final GameBoard gameBoard;
    private final List<Player> players = new LinkedList<>();

    @Autowired
    public GameLogic(GameController gameController, GameBoard gameBoard) {
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

    public void movePlayer(String playerName, Direction direction) {
        Player player = gameController.getPlayer(playerName);
        Field actualField = player.getField();
        Field destinationCoordinates = new Field(
                actualField.getX() + direction.getCoordinates().getX(),
                actualField.getY() + direction.getCoordinates().getY());
        player.setField(destinationCoordinates);
        actualField.clearField();
    }
}
