package com.codecool.elgrande.model.game.actors;

public class Statistics {
    private int attack;
    private int defence;
    private int radius;

    public Statistics(int attack, int defence, int radius) {
        this.attack = attack;
        this.defence = defence;
        this.radius = radius;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getRadius() {
        return radius;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
