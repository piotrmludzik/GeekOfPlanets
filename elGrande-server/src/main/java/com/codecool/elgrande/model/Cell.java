package com.codecool.elgrande.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cell {
    private Coordinates coordinates;
    private Actor actor;

    public Cell(Coordinates coordinates, Actor actor) {
        this.coordinates = coordinates;
        this.actor = actor;
    }

    @Autowired
    public Cell(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.actor = null;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void clearCell() {
        this.actor = null;
    }

    @Override
    public String toString() {
        return String.format("Cell[actor=%s, coordinates=%s]", actor, coordinates);
    }
}