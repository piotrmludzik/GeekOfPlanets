package com.codecool.geekofplanets.world.model.objects.buildings.mines;

import com.codecool.geekofplanets.world.model.Resources;


public class MetalMine extends Mine {

    public MetalMine() {
        this.setCost(new Resources(120, 30, 0, 0));
        this.setProduction(15);
    }

}



