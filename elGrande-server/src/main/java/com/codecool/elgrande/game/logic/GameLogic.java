package com.codecool.elgrande.game.logic;

import com.codecool.elgrande.game.jdbc.service.PlayerService;
import com.codecool.elgrande.game.model.Field;
import com.codecool.elgrande.game.model.GameBoard;
import com.codecool.elgrande.game.model.actors.Player;
import com.codecool.elgrande.game.model.objects.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class GameLogic {
    private final GameBoard gameBoard;
    private final List<Player> players = new LinkedList<>();
    private final PlayerService playerService;

    @Autowired
    public GameLogic(GameBoard gameBoard, PlayerService playerService) {
        this.gameBoard = gameBoard;
        this.playerService = playerService;
    }

    public void createPlayer(String name, Field field, int userId) {
        Planet planet = gameBoard.getEmptyPlanet();
        Player player = new Player(planet);
        player.setName(name);
        player.setField(field);
        player.setUserId(userId);
        players.add(player);
        addPlayer(player);
    }

    private void addPlayer(Player player) {
        playerService.addNewPlayer(player);
        gameBoard.addFieldEntity(player);
    }

    public Player getPlayer(int id) {
        return playerService.getPlayerById(id);
    }

    public void movePlayer(int id, Direction direction) {
        Player player = this.getPlayer(id);
        Field actualField = player.getField();
        Field destinationCoordinates = new Field(actualField.getX()+direction.getCoordinates().getX(), actualField.getY()+direction.getCoordinates().getY());
        player.setCoordinates(destinationCoordinates);
        actualField.clearCell();
    }
}
