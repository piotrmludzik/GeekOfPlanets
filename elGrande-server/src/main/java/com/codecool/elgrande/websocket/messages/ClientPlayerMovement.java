package com.codecool.elgrande.websocket.messages;

import com.codecool.elgrande.logic.Direction;

public class ClientPlayerMovement {
    private final String playerName;
    private final Direction direction;

    public ClientPlayerMovement(String playerName, Direction direction) {
        this.playerName = playerName;
        this.direction = direction;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "The client's message: the player " + playerName + " move towards " + direction;
    }
}
