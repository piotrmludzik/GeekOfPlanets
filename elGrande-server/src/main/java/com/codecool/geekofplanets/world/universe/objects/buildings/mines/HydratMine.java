package com.codecool.geekofplanets.world.universe.objects.buildings.mines;

import com.codecool.geekofplanets.world.universe.Resources;


public class HydratMine extends Mine {

    public HydratMine() {
        super.setCost(new Resources(100, 80, 0, 0));
        super.setProduction(12);
    }

}

