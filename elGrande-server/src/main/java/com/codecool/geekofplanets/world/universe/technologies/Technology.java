package com.codecool.geekofplanets.world.universe.technologies;


import com.codecool.geekofplanets.world.universe.Resources;

public abstract class Technology {
    private Resources cost;
    private int level = 0;

    public Technology(Resources cost){
        this.cost = cost;
    }

    public Resources getCost(){
        return cost;
    }

    public void levelUp(){
        this.level += 1;
        cost.substractCost(cost.percentOfRecources(-0.5));
    }
}
