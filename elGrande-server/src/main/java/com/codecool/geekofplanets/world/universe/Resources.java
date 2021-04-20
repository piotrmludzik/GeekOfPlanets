package com.codecool.geekofplanets.world.universe;


import com.codecool.geekofplanets.world.jdbc.model.ResourcesModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resources {
    private int metal;
    private int hydrate;
    private int ether;
    private int antimatter;

    public Resources(int metal, int hydrate, int ether, int antimatter){
        this.metal = metal;
        this.hydrate = hydrate;
        this.ether = ether;
        this.antimatter = antimatter;
    }

    public Resources(ResourcesModel resources) {
        this.metal = resources.getMetal();
        this.hydrate = resources.getHydrate();
        this.ether = resources.getEther();
        this.antimatter = resources.getAntimatter();
    }

    public void substractCost(Resources cost){
        this.metal -= cost.metal;
        this.hydrate -= cost.hydrate;
        this.ether -= cost.ether;
        this.antimatter -= cost.antimatter;
    }

    public void extract(long time, Resources extraction){
        this.metal += extraction.metal*time/3600;
        this.hydrate += extraction.hydrate*time/3600;
        this.ether += extraction.ether*time/3600;
    }

    public Resources percentOfRecources(double percent){
        return new Resources((int)(this.metal*percent), (int)(this.hydrate *percent), (int)(this.ether*percent), (int)(this.antimatter*percent));
    }
}
