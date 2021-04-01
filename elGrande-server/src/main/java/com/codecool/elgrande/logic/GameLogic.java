package com.codecool.elgrande.logic;

import com.codecool.elgrande.model.Cell;
import com.codecool.elgrande.model.GameBoard;
import com.codecool.elgrande.model.Planet;
import com.codecool.elgrande.model.Player;
import com.codecool.elgrande.service.PlayerService;
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

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Player createPlayer(int id, String name, Cell position, Planet planet) {
        Player player = new Player(id, name, position, planet);
        this.addPlayer(player);
        return player;
    }

    public Player createPlayer(String name) {
        int newId = getId();
        Planet planet = gameBoard.getEmptyPlanet();
        Player player = new Player(newId, name, planet);
        this.addPlayer(player);
        return player;
    }

    private void addPlayer(Player player) {
        playerService.addNewPlayer(player);
    }

    public Player getPlayer(int id) {
        return playerService.getPlayerById(id);
    }

    public void movePlayer(int id, Direction direction) {
        Player player = this.getPlayer(id);
        Cell actualCell = player.getCoordinates();
        Cell destinationCoordinates = new Cell(actualCell.getX()+direction.getCoordinates().getX(), actualCell.getY()+direction.getCoordinates().getY());
        player.setCoordinates(destinationCoordinates);
        actualCell.clearCell();
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
