package com.codecool.elgrande.model.game;

import com.codecool.elgrande.model.game.actors.Player;
import com.codecool.elgrande.model.game.objects.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Field {
    private Player player;
    private Planet planet;
    private int x;
    private int y;

    @Autowired
    public Field() {}

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Player getPlayer() {
        return player;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void clearCell(){
        this.player = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Field
                && ((Field) obj).x == this.x
                && ((Field) obj).y == this.y;
    }

    @Override
    public String toString() {
        return String.format("Coordinates[x=%d, y=%d]", x, y);
    }
}
