package com.codecool.elgrande.model;

import com.codecool.elgrande.model.buildings.*;
import com.codecool.elgrande.model.buildings.Mine;
import com.codecool.elgrande.model.buildings.Mines.EtherMine;
import com.codecool.elgrande.model.buildings.Mines.HydratMine;
import com.codecool.elgrande.model.buildings.Mines.MetalMine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Planet extends SpaceObject {
    private boolean colonized = false;


    @Autowired
    public Planet(Field position, String name){
        super(position, name);
        this.getField().setPlanet(this);
    }

    public boolean getColonized(){
        return colonized;
    }

    public void Colonize(){
        this.colonized = true;
    }


    public Field getPosition() {
        return this.getField();
    }

    public static class Buildings {
        MetalMine metalMine;
        HydratMine hydratMine;
        EtherMine etherMine;
        Shypyard shypyard;
        Docks docks;
        Laboratory laboratory;
        PowerPlant powerPlant;
        Storage storage;

    }
}
