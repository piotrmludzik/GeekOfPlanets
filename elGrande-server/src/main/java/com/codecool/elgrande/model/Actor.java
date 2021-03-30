package com.codecool.elgrande.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Actor {
    private int id;
    private Cell cell;

    @Autowired
    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public Actor(int id, Cell cell) {
        this.id = id;
        this.cell = cell;
        this.cell.setActor(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public int getX() {
        return cell.getCoordinates().getX();
    }

    public int getY() {
        return cell.getCoordinates().getY();
    }

    @Override
    public String toString() {
        return String.format("Actor[id=%d, x=%d, y=%d]", id, getX(), getY());
    }
}