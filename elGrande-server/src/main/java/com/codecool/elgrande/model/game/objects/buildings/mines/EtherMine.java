package com.codecool.elgrande.model.game.objects.buildings.mines;

import com.codecool.elgrande.model.game.Resources;


public class EtherMine extends Mine {

    public EtherMine(){
        this.setCost(new Resources(150, 50, 0, 0));
        this.setProduction(10);
    }

    public void levelUp(){}
}
