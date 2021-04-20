package com.codecool.geekofplanets.world.universe.objects.buildings;


import com.codecool.geekofplanets.world.universe.Resources;

public class Storage  extends Building {

    public Storage(){
        setCost(new Resources(2000, 1000, 0,0));
    }

    public void levelUp(){
        super.levelUp(-2);
    }
}
