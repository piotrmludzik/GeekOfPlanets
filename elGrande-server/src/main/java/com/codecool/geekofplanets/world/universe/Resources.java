package com.codecool.geekofplanets.world.universe;

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

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public void setHydrate(int hydrate) {
        this.hydrate = hydrate;
    }

    public void setEther(int ether) {
        this.ether = ether;
    }

    public void setAntimatter(int antimatter) {
        this.antimatter = antimatter;
    }

    public int getMetal() {
        return metal;
    }

    public int getHydrate() {
        return hydrate;
    }

    public int getEther() {
        return ether;
    }

    public int getAntimatter() {
        return antimatter;
    }
}
