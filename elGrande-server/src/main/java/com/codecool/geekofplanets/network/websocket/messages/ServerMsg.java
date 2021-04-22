package com.codecool.geekofplanets.network.websocket.messages;

public class ServerMsg {
    private final PlayerMovementMsg playerMovementMsg;
    private final VisibleFields visibleFields;

    public ServerMsg(PlayerMovementMsg playerMovementMsg, VisibleFields visibleFields) {
        this.playerMovementMsg = playerMovementMsg;
        this.visibleFields = visibleFields;
    }

    @Override
    public String toString() {
        return "The server's message: " + playerMovementMsg + ", " + visibleFields;
    }
}
