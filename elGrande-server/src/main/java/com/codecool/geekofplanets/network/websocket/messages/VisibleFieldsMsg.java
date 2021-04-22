package com.codecool.geekofplanets.network.websocket.messages;

import com.codecool.geekofplanets.world.universe.Field;

import java.util.ArrayList;
import java.util.List;


public class VisibleFieldsMsg {
    private List<Field> fields = new ArrayList<>();


    public VisibleFieldsMsg(List<Field> fields) {
        this.fields = fields;
    }

    public List<Field> getFields (){
        return this.fields;
    }
}
