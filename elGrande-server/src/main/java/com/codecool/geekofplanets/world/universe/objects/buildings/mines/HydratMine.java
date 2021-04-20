package com.codecool.geekofplanets.world.universe.objects.buildings.mines;

import com.codecool.geekofplanets.world.universe.Resources;


public class HydratMine extends Mine {

    public HydratMine() {
        this.setCost(new Resources(100, 80, 0, 0));
        this.setProduction(12);
    }

}

