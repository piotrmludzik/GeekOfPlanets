package com.codecool.geekofplanets.network.websocket.messages;

import java.util.Map;

public class VisibleFields {
    private final Map<String, FieldMsg> fieldsMap;

    public VisibleFields(Map<String, FieldMsg> fieldsMap) {
        this.fieldsMap = fieldsMap;
    }
}
