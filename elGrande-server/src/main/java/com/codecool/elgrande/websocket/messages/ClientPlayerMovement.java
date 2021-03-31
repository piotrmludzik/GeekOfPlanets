package com.codecool.elgrande.websocket.messages;

import com.codecool.elgrande.logic.Direction;

public class ClientPlayerMovement {

    private int playerId;
    private Direction direction;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = Direction.getDirection(direction);
    }

    @Override
    public String toString() {
        return String.format("ClientPlayerMovement[playerId=%d, direction=%s]", playerId, direction);
    }
}