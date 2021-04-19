package com.codecool.geekofplanets.model.game.objects.buildings;

import com.codecool.elgrande.model.game.Resources;

public class Storage  extends Building {

    public Storage(){
        setCost(new Resources(2000, 1000, 0,0));
    }

    public void levelUp(){
        this.addLevel();
        this.getCost().substractCost(this.getCost().percentOfRecources(-2));
    }


}
