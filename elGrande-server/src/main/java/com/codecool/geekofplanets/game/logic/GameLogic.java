package com.codecool.geekofplanets.game.logic;

import com.codecool.geekofplanets.game.controller.GameController;
import com.codecool.geekofplanets.world.jdbc.service.PlayerService;
import com.codecool.geekofplanets.world.universe.Field;
import com.codecool.geekofplanets.world.universe.GameBoard;
import com.codecool.geekofplanets.world.universe.actors.Player;
import com.codecool.geekofplanets.world.universe.objects.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Component
public class GameLogic {
    private final GameController gameController;
    private final GameBoard gameBoard;
    private final List<Player> players = new LinkedList<>();
    private final PlayerService playerService;

    @Autowired
    public GameLogic(GameController gameController, GameBoard gameBoard, PlayerService playerService) {
        this.gameController = gameController;
        this.gameBoard = gameBoard;
        this.playerService = playerService;
    }

    public void createPlayer(String name, Field field, UUID userId) {
        Planet planet = gameBoard.getEmptyPlanet();
        Player player = new Player(planet);
        player.setName(name);
        player.setOnField(field);
        player.setUserId(userId);
        players.add(player);
        addPlayer(player);
    }

    private void addPlayer(Player player) {
        playerService.addNewPlayer(player);
        gameBoard.addPlayer(player);
    }

    public void movePlayer(String playerName, Direction direction) {
        Player player = gameController.getPlayer(playerName);
        Field actualField = player.getField();
        Field destinationCoordinates = new Field(
                actualField.getX() + direction.getCoordinates().getX(),
                actualField.getY() + direction.getCoordinates().getY());
        player.setOnField(destinationCoordinates);
        actualField.clearField();
    }
}
