package com.codecool.elgrande.logic;

import com.codecool.elgrande.model.Actor;
import com.codecool.elgrande.model.Cell;
import com.codecool.elgrande.model.Coordinates;
import com.codecool.elgrande.model.GameBoard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameLogic {
    private final GameBoard gameBoard;
    private final List<Actor> actors = new ArrayList<>();

    public GameLogic(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Actor createActor(int id, Coordinates coordinates) {
        Actor actor = new Actor(id, gameBoard.getCell(coordinates));
        this.addActor(actor);
        return actor;
    }

    private void addActor(Actor actor) {
        actors.add(actor);
    }

    public Actor getActor(int id) {
        return actors.stream().
                filter(actor -> actor.getId() == id).
                findAny().
                orElseThrow(() -> new RuntimeException(String.format("No actor with id %d", id)));
    }

    public void moveActor(int id, Direction direction) {
        Actor actor = this.getActor(id);
        Cell actualCell = actor.getCell();
        Cell destinationCell = this.gameBoard.getCell(new Coordinates(actor.getX() + direction.getCoordinates().getX(), actor.getY() + direction.getCoordinates().getY()));
        actor.setCell(destinationCell);
        actualCell.clearCell();
    }
}