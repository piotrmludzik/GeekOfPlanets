package com.codecool.elgrande.logic;

import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.game.GameBoard;
import com.codecool.elgrande.model.game.objects.Planet;
import com.codecool.elgrande.model.game.actors.Player;
import com.codecool.elgrande.jdbc.service.game.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameLogic {
    private final GameBoard gameBoard;
    private final PlayerService playerService;

    @Autowired
    public GameLogic(GameBoard gameBoard, PlayerService playerService) {
        this.gameBoard = gameBoard;
        this.playerService = playerService;
    }

    public Player createPlayer(int id, String name, Field position, Planet planet) {
        Player player = new Player(id, name, position, planet);
        this.addPlayer(player);
        return player;
    }

    public void createPlayer(String name) {
        int newId = getId();
        Planet planet = gameBoard.getEmptyPlanet();
        Player player = new Player(newId, name, planet);
        this.addPlayer(player);
        gameBoard.addSpaceObject(player);
    }

    private void addPlayer(Player player) {
        playerService.addNewPlayer(player);
        gameBoard.addSpaceObject(player);
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

    private int getId(){
        if (playerService.getPlayerCount() == 0){
            return 1;
        }
        else {
            return (int) playerService.getPlayerCount() + 1;
        }
    }
}
