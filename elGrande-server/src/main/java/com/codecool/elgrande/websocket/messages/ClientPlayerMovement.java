package com.codecool.elgrande.websocket.messages;

public class ClientPlayerMovement {
    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "The client's message: the player move towards " + direction;
    }
}
