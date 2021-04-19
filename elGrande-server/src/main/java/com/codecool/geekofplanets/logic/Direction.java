package com.codecool.geekofplanets.logic;

import com.codecool.elgrande.model.game.Field;
import com.codecool.geekofplanets.model.game.Field;

public enum Direction {
    NORTH("N") {
        @Override
        public Field getCoordinates() {
            return new Field(0,-1);
        }
    },
    SOUTH("S") {
        @Override
        public Field getCoordinates() {
            return new Field(0,1);
        }
    },
    EAST("E") {
        @Override
        public Field getCoordinates() {
            return new Field(1,0);
        }
    },
    WEST("W") {
        @Override
        public Field getCoordinates() {
            return new Field(-1,0);
        }
    };

    String shortName;

    Direction(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public Field getCoordinates() {
        return new Field(0,0);
    }

    static public Direction getDirection(String shortName) {
        for (Direction d : Direction.values())
            if (d.shortName.equals(shortName))
                return d;

        throw new IllegalStateException("The short name was not found.");
    }
}
