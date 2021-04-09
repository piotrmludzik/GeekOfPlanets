package com.codecool.elgrande.model.game.objects.buildings.mines;

import com.codecool.elgrande.model.game.objects.buildings.Building;

abstract class Mine extends Building {
    private int production;

    public int getProduction(){
        return this.production;
    }

    public void setProduction(int production){
        this.production = production;
    }

    public void levelUp(){
        this.addLevel();
        this.getCost().substractCost(this.getCost().percentOfRecources(-0.3));
        this.setProduction((int)(getProduction()*1.2));
    }

}
