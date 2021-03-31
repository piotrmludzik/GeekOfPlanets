package com.codecool.elgrande.model;

public class Cost {
    private int metal;
    private int hydrat;
    private int ether;
    private int antimatter;

    public void setAntimatter(int antimatter) {
        this.antimatter = antimatter;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public void setHydrat(int hydrat) {
        this.hydrat = hydrat;
    }

    public void setEther(int ether) {
        this.ether = ether;
    }

    public int getAntimatter() {
        return antimatter;
    }

    public int getMetal() {
        return metal;
    }

    public int getHydrat() {
        return hydrat;
    }

    public int getEther() {
        return ether;
    }
}
