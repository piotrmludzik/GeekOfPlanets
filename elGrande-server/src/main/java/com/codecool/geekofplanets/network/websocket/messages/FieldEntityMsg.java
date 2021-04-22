package com.codecool.geekofplanets.network.websocket.messages;

public class FieldEntityMsg {
    private final String fieldEntity;


    public FieldEntityMsg(String fieldEntity) {
        this.fieldEntity = fieldEntity;
    }

    public String getFieldEntity() {
        return fieldEntity;
    }
}
