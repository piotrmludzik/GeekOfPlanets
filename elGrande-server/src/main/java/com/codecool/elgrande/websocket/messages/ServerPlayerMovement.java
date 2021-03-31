package com.codecool.elgrande.websocket.messages;

public class ServerPlayerMovement {
    private final int id;
    private final int targetX;
    private final int targetY;

    public ServerPlayerMovement(int id, int targetX, int targetY) {
        this.id = id;
        this.targetX = targetX;
        this.targetY = targetY;
    }

    public int getId() {
        return id;
    }

    public int getTargetX() {
        return targetX;
    }

    public int getTargetY() {
        return targetY;
    }
}