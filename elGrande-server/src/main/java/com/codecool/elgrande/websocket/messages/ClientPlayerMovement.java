package com.codecool.elgrande.websocket.messages;

public class ClientPlayerMovement {
    private final String playerName;
    private final int targetX;
    private final int targetY;

    public ClientPlayerMovement(String playerName, int targetX, int targetY) {
        this.playerName = playerName;
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }

    @Override
    public String toString() {
        return "The client's message: the player " + playerName + " move on a " + targetX + ", " + targetY + " field.";
    }
}
