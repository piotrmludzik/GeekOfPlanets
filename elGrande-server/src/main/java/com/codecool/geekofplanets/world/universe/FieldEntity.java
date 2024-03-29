package com.codecool.geekofplanets.world.universe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class FieldEntity {
    private Field field;
    private String name;

    public FieldEntity(Field field, String name) {
        this.field = field;
        this.name = name;
    }

    public FieldEntity(Field field) {
        this.field = field;
    }
}
