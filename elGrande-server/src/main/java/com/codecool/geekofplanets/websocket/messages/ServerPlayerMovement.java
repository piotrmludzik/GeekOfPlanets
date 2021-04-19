package com.codecool.geekofplanets.websocket.messages;

public class ServerPlayerMovement {
    private final String playerName;
    private final int targetX;
    private final int targetY;

    public ServerPlayerMovement(String playerName, int targetX, int targetY) {
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
        return "The server's message: the player " + playerName + " move on a " + targetX + ", " + targetY + " field.";
    }
}
