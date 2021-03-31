package com.codecool.elgrande.websocket.messages;

public class ClientPlayerMovement {
    private final int playerId;
    private final int targetX;
    private final int targetY;

    public ClientPlayerMovement(int id, int targetX, int targetY) {
        this.playerId = id;
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    @Override
    public String toString() {
        return "The client's message: the player " + playerId + " move on a " + targetX + ", " + targetY + " field.";
    }
}
