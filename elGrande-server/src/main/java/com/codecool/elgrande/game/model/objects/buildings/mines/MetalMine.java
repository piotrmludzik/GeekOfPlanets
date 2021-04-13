package com.codecool.elgrande.game.model.objects.buildings.mines;

import com.codecool.elgrande.game.model.Resources;

public class MetalMine extends Mine {


    public MetalMine() {
        this.setCost(new Resources(120, 30, 0, 0));
        this.setProduction(15);
    }

    public int getProduction(){
        return this.getProduction();
    }

    @Override
    public void levelUp() {

    }
}



