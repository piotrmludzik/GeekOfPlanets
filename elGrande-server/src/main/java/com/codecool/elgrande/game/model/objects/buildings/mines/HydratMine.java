package com.codecool.elgrande.game.model.objects.buildings.mines;

import com.codecool.elgrande.game.model.Resources;

public class HydratMine extends Mine {

    public HydratMine() {
        this.setCost(new Resources(100, 80, 0, 0));
        this.setProduction(12);
    }




}

