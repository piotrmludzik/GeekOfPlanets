package com.codecool.geekofplanets.network.websocket.messages;


public class FieldMsg {
    private final int x;
    private final int y;
    private FieldEntityMsg fieldEntity;

    public FieldMsg(int x, int y, FieldEntityMsg fieldEntity) {
        this.x = x;
        this.y = y;
        this.fieldEntity = fieldEntity;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public FieldEntityMsg getFieldEntity() {
        return fieldEntity;
    }
}
