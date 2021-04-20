package com.codecool.geekofplanets.world.universe.objects.buildings;


import com.codecool.geekofplanets.world.universe.Resources;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Building {
    private Resources cost;
    private int energyUsage;
    private int level = 0;

    public abstract void levelUp();
    public void addLevel(){
        this.level += 1;
    }
}
