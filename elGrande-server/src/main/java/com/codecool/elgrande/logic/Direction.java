package com.codecool.elgrande.logic;

import com.codecool.elgrande.model.Coordinates;

public enum Direction {
    NORTH("N") {
        @Override
        public Coordinates getCoordinates() {
            return new Coordinates(0,-1);
        }
    },
    SOUTH("S") {
        @Override
        public Coordinates getCoordinates() {
            return new Coordinates(0,1);
        }
    },
    EAST("E") {
        @Override
        public Coordinates getCoordinates() {
            return new Coordinates(1,0);
        }
    },
    WEST("W") {
        @Override
        public Coordinates getCoordinates() {
            return new Coordinates(-1,0);
        }
    };

    String shortName;

    Direction(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public Coordinates getCoordinates() {
        return new Coordinates(0,0);
    }

    static public Direction getDirection(String shortName) {
        for (Direction d : Direction.values())
            if (d.shortName.equals(shortName))
                return d;

        throw new IllegalStateException("The short name was not found.");
    }
}