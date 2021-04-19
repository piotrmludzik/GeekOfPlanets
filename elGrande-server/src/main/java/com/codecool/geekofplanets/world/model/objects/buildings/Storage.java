package com.codecool.geekofplanets.world.model.objects.buildings;


import com.codecool.geekofplanets.world.model.Resources;

public class Storage  extends Building {

    public Storage(){
        setCost(new Resources(2000, 1000, 0,0));
    }

    public void levelUp(){
        this.addLevel();
        this.getCost().substractCost(this.getCost().percentOfRecources(-2));
    }


}
