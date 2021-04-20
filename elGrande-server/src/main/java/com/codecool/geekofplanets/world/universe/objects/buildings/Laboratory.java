package com.codecool.geekofplanets.world.universe.objects.buildings;


import com.codecool.geekofplanets.world.universe.Resources;

public class Laboratory  extends Building {

    public Laboratory(){
        setCost(new Resources(280, 180, 0,0));
    }

    public void levelUp() {
        super.levelUp(-0.5);
    }
}
