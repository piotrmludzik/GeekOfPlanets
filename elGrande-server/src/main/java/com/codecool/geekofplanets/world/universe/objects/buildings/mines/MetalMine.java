package com.codecool.geekofplanets.world.universe.objects.buildings.mines;

import com.codecool.geekofplanets.world.universe.Resources;


public class MetalMine extends Mine {

    public MetalMine() {
        super.setCost(new Resources(120, 30, 0, 0));
        super.setProduction(15);
    }

}



