package com.codecool.geekofplanets.world.universe.objects.buildings;


import com.codecool.geekofplanets.world.jdbc.model.BuildingsModel;
import com.codecool.geekofplanets.world.universe.Resources;
import com.codecool.geekofplanets.world.universe.objects.buildings.mines.EtherMine;
import com.codecool.geekofplanets.world.universe.objects.buildings.mines.HydratMine;
import com.codecool.geekofplanets.world.universe.objects.buildings.mines.MetalMine;
import org.springframework.stereotype.Component;

@Component
public class Buildings {
    private final EtherMine etherMine = new EtherMine();
    private final HydratMine hydratMine = new HydratMine();
    private final MetalMine metalMine = new MetalMine();
    private transient Docks docks;
    private final Laboratory laboratory = new Laboratory();
    private final PowerPlant powerPlant = new PowerPlant();
    private final Shipyard shipyard = new Shipyard();
    private final Storage storage = new Storage();
    private Resources extraction;
    private final Building[] availableToBuild = new Building[9];

    public Buildings(BuildingsModel buildingsModel) {
    }

    public void buildNew(String name, Resources resources){
        switch (name) {
            case "metal mine":
                resources.substractCost(metalMine.getCost());
                this.metalMine.levelUp();
                break;
            case "hydrat mine":
                resources.substractCost(hydratMine.getCost());
                this.hydratMine.levelUp();
                break;
            case "ether mine":
                resources.substractCost(etherMine.getCost());
                this.etherMine.levelUp();
                break;
            case "docks":
                resources.substractCost(docks.getCost());
                this.docks.levelUp();
                break;
            case "laboratory":
                resources.substractCost(laboratory.getCost());
                this.laboratory.levelUp();
                break;
            case "power plant":
                resources.substractCost(powerPlant.getCost());
                this.powerPlant.levelUp();
                break;
            case "shipyard":
                resources.substractCost(shipyard.getCost());
                this.shipyard.levelUp();
                break;
            case "storage":
                resources.substractCost(storage.getCost());
                this.storage.levelUp();
        }
    }

    public Resources getExtraction(){
        extraction.setMetal(this.metalMine.getProduction());
        extraction.setEther(this.etherMine.getProduction());
        extraction.setHydrate(this.hydratMine.getProduction());
        return extraction;
    }
}
