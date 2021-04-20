package com.codecool.geekofplanets.world.model.objects.buildings;

import com.codecool.geekofplanets.world.model.Resources;

public class Docks extends Building {

    public Docks(){
        this.setCost(new Resources(1500, 750, 250, 0));
    }

    public void levelUp(){
        this.addLevel();
        this.getCost().substractCost(this.getCost().percentOfRecources(-2));
    }
}
