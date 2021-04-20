package com.codecool.geekofplanets.world.universe.objects.buildings;


import com.codecool.geekofplanets.world.universe.Resources;

public class PowerPlant  extends Building {
    private int production;

    public PowerPlant(){
        this.setCost(new Resources(200, 80, 0, 0));
        this.production= 500;
    }

    public void levelUp(){
        super.levelUp(-1.5);
        this.production += production;
    }
}
