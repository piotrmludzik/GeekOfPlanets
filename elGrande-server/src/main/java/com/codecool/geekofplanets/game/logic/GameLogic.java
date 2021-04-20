package com.codecool.geekofplanets.game.logic;

import com.codecool.geekofplanets.game.controller.GameController;
import com.codecool.geekofplanets.world.model.Field;
import com.codecool.geekofplanets.world.model.GameBoard;
import com.codecool.geekofplanets.world.model.actors.Player;
import com.codecool.geekofplanets.world.model.objects.Planet;
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

    public void createPlayer(String name, Field field) {
        Planet planet = gameBoard.getEmptyPlanet();
        Player player = new Player(planet);
        player.setName(name);
        player.setField(field);
        players.add(player);
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
