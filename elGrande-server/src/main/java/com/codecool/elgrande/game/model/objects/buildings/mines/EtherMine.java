package com.codecool.elgrande.game.model.objects.buildings.mines;

import com.codecool.elgrande.game.model.Resources;


public class EtherMine extends Mine {

    public EtherMine(){
        this.setCost(new Resources(150, 50, 0, 0));
        this.setProduction(10);
    }

    public void levelUp(){}
}
