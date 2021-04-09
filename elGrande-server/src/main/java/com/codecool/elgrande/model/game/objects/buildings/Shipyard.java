package com.codecool.elgrande.model.game.objects.buildings;

import com.codecool.elgrande.model.game.Resources;

public class Shipyard extends Building {

    public Shipyard(){
        this.setCost(new Resources(400,80,0,0));
    }


    public void levelUp(){
        this.addLevel();
        this.getCost().substractCost(this.getCost().percentOfRecources(-0.75));
    }


}
