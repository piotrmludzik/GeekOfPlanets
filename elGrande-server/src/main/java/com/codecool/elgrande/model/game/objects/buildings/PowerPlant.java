package com.codecool.elgrande.model.game.objects.buildings;

import com.codecool.elgrande.model.game.Resources;

public class PowerPlant  extends Building {
    private int production;

    public PowerPlant(){
        this.setCost(new Resources(200, 80, 0, 0));
        this.production= 500;
    }

    public void levelUp(){
        this.addLevel();
        this.getCost().substractCost(this.getCost().percentOfRecources(-1.5));
        this.production += production;
    }
}
