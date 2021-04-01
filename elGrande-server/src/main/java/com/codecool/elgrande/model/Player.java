package com.codecool.elgrande.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Player extends SpaceObject {
    private int id;
    private Statistics statistics;
    private Planet planet;

    @Autowired
    public Player(int id, String name, Field field, Planet planet) {
        super(field, name);
        this.id = id;

        this.statistics = new Statistics(0,0,10);
        this.planet = planet;
        this.getField().setPlayer(this);
    }

    public Player(int id, String name, Planet planet ) {
        super(planet.getPosition(), name);
        this.id = id;
        this.statistics = new Statistics(0,0,8);
        this.planet = planet;
        this.getField().setPlayer(this);
    }

    public int getId() {
        return id;
    }


    public void setCoordinates(Field field) {
        this.getField().setPlayer(this);
    }

    @Override
    public String toString() {
        return String.format("Actor[id=%d, x=%d, y=%d]", id, this.getField().getX(), this.getField().getY());
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