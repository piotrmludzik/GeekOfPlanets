package com.codecool.geekofplanets.model.game.objects.buildings.mines;

import com.codecool.elgrande.model.game.Resources;


public class MetalMine extends Mine {

    public MetalMine() {
        this.setCost(new Resources(120, 30, 0, 0));
        this.setProduction(15);
    }

}



