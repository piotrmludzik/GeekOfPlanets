package com.codecool.geekofplanets.world.universe.objects.buildings.mines;


import com.codecool.geekofplanets.world.universe.objects.buildings.Building;

abstract class Mine extends Building {
    private int production;

    public int getProduction(){
        return this.production;
    }

    public void setProduction(int production){
        this.production = production;
    }

    public void levelUp(){
        super.levelUp(-0.3);
        this.setProduction((int)(getProduction()*1.2));
    }

}
