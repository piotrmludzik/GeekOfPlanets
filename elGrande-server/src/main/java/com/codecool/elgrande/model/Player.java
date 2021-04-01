package com.codecool.elgrande.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="user")
public class Player {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    private transient Cell cell;
    private transient Statistics statistics;
    private transient Planet planet;

    @Autowired
    public Player() {
        this.cell.setPlayer(this);
    }

    public Player(int id, String name, Cell cell, Planet planet) {
        this.id = id;
        this.name = name;
        this.cell = cell;
        this.statistics = new Statistics(0,0,10);
        this.planet = planet;
        this.cell.setPlayer(this);
    }

    public Player(int id, String name, Planet planet ) {
        this.id = id;
        this.name = name;
        this.cell = planet.getPosition();
        this.statistics = new Statistics(0,0,8);
        this.planet = planet;
        this.cell.setPlayer(this);
    }

    public Player(int id, Cell cell) {
        this.id = id;
        this.cell = cell;
        this.cell.setPlayer(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cell getCoordinates() {
        return cell;
    }

    public void setCoordinates(Cell cell) {
        this.cell = cell;
        this.cell.setPlayer(this);
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    @Override
    public String toString() {
        return String.format("Actor[id=%d, x=%d, y=%d]", id, getX(), getY());
    }

    public static class Statistics {
        private int atack;
        private int defence;
        private int radius;

        public Statistics(int atack, int defence, int radius){
            this.atack = atack;
            this.defence = defence;
            this.radius = radius;
        }

        public int getAtack() {
            return atack;
        }

        public int getDefence() {
            return defence;
        }

        public int getRadius() {
            return radius;
        }

        public void setAtack(int atack) {
            this.atack = atack;
        }

        public void setDefence(int defence) {
            this.defence = defence;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }
    }
}
