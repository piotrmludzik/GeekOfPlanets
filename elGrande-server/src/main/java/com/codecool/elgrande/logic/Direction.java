package com.codecool.elgrande.logic;

import com.codecool.elgrande.model.Cell;

public enum Direction {
    NORTH("N") {
        @Override
        public Cell getCoordinates() {
            return new Cell(0,-1);
        }
    },
    SOUTH("S") {
        @Override
        public Cell getCoordinates() {
            return new Cell(0,1);
        }
    },
    EAST("E") {
        @Override
        public Cell getCoordinates() {
            return new Cell(1,0);
        }
    },
    WEST("W") {
        @Override
        public Cell getCoordinates() {
            return new Cell(-1,0);
        }
    };

    String shortName;

    Direction(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public Cell getCoordinates() {
        return new Cell(0,0);
    }

    static public Direction getDirection(String shortName) {
        for (Direction d : Direction.values())
            if (d.shortName.equals(shortName))
                return d;

        throw new IllegalStateException("The short name was not found.");
    }
}