package com.codecool.elgrande.model;

public abstract class SpaceObject {
    private Field position;
    private String name;

    public SpaceObject(Field field, String name){
        this.position = field;
        this.name = name;
    }

    public Field getField(){
        return this.position;
    }
}
