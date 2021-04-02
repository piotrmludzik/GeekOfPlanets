package com.codecool.elgrande.model.game;

public abstract class FieldEntity {

    private final Field position;
    private final String name;

    public FieldEntity(Field field, String name){
        this.position = field;
        this.name = name;
    }

    public Field getField(){
        return this.position;
    }

    public String getName() {
        return name;
    }
}
