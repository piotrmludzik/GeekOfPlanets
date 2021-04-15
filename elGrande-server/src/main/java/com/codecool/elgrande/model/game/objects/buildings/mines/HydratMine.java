package com.codecool.elgrande.model.game.objects.buildings.mines;

import com.codecool.elgrande.model.game.Resources;


public class HydratMine extends Mine {

    public HydratMine() {
        this.setCost(new Resources(100, 80, 0, 0));
        this.setProduction(12);
    }

}

