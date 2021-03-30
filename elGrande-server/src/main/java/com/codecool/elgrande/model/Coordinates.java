package com.codecool.elgrande.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Coordinates {
    private int x;
    private int y;

    @Autowired
    public Coordinates() {}

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
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
        return obj instanceof Coordinates
                && ((Coordinates) obj).x == this.x
                && ((Coordinates) obj).y == this.y;
    }

    @Override
    public String toString() {
        return String.format("Coordinates[x=%d, y=%d]", x, y);
    }
}