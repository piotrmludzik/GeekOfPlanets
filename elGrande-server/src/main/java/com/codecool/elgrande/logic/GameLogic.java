package com.codecool.elgrande.logic;

import com.codecool.elgrande.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameLogic {
    private final GameBoard gameBoard;
    private final List<Player> players = new ArrayList<>();

    public GameLogic(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
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
        players.add(player);
    }

    public Player getPlayer(int id) {
        return players.stream().
                filter(player -> player.getId() == id).
                findAny().
                orElseThrow(() -> new RuntimeException(String.format("No actor with id %d", id)));
    }

    public void movePlayer(int id, Direction direction) {
        Player player = this.getPlayer(id);
        Cell actualCell = player.getCoordinates();
        Cell destinationCoordinates = new Cell(actualCell.getX()+direction.getCoordinates().getX(), actualCell.getY()+direction.getCoordinates().getY());
        player.setCoordinates(destinationCoordinates);
        actualCell.clearCell();
    }

    private int getId(){
        if (players.get(-1) == null){
            return 1;
        }
        else {
            return players.get(-1).getId() +1;
        }
    }
}