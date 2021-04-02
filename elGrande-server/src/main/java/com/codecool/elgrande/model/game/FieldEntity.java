package com.codecool.elgrande.model.game;

public abstract class FieldEntity {

    private final Field field;
    private String name;

    public FieldEntity(Field field){
        this.field = field;
    }

    public Field getField(){
        return this.field;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
