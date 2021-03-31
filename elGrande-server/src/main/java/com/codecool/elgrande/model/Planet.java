package com.codecool.elgrande.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Planet {
    private boolean colonized = false;
    private Cell position;

    @Autowired
    public Planet(Cell position){
        this.position = position;
    }

    public boolean getColonized(){
        return colonized;
    }

    public void Colonize(){
        this.colonized = true;
    }


    public Cell getPosition() {
        return position;
    }

    public static class Buildings {
    }
}
