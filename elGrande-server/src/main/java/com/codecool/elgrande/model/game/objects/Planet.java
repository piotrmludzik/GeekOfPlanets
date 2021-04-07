package com.codecool.elgrande.model.game.objects;

import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.game.FieldEntity;
import com.codecool.elgrande.model.game.objects.buildings.*;
import com.codecool.elgrande.model.game.objects.buildings.mines.EtherMine;
import com.codecool.elgrande.model.game.objects.buildings.mines.HydratMine;
import com.codecool.elgrande.model.game.objects.buildings.mines.MetalMine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Planet extends FieldEntity {

    private boolean colonized = false;

    @Autowired
    public Planet(Field position){
        super(position);
        this.getField().setPlanet(this);
    }

    public boolean getColonized(){
        return colonized;
    }

    public void colonize(){
        this.colonized = true;
    }

    public void setName(String name){
        super.setName(name);
    }

    public Field getPosition() {
        return this.getField();
    }

    public static class Buildings {
        MetalMine metalMine;
        HydratMine hydratMine;
        EtherMine etherMine;
        Shipyard shipyard;
        Docks docks;
        Laboratory laboratory;
        PowerPlant powerPlant;
        Storage storage;
    }
}
