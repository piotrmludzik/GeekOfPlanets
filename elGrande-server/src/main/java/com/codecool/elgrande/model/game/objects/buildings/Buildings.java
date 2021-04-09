package com.codecool.elgrande.model.game.objects.buildings;

import com.codecool.elgrande.model.game.Resources;
import com.codecool.elgrande.model.game.objects.buildings.mines.EtherMine;
import com.codecool.elgrande.model.game.objects.buildings.mines.HydratMine;
import com.codecool.elgrande.model.game.objects.buildings.mines.MetalMine;

public class Buildings {
    private final MetalMine metalMine = new MetalMine();
    private final EtherMine etherMine = new EtherMine();
    private final HydratMine hydratMine = new HydratMine();
    private final Docks docks = new Docks();
    private final Laboratory laboratory = new Laboratory();
    private final PowerPlant powerPlant = new PowerPlant();
    private final Shipyard shipyard = new Shipyard() ;
    private final Storage storage = new Storage();
    private Resources extraction;



    public void buildNew(String name, Resources resources){
        if (name.equals("metal mine")) {
            resources.substractCost(metalMine.getCost());
            this.metalMine.levelUp();
        }
        else if (name.equals("hydrat mine")){
            resources.substractCost(hydratMine.getCost());
            this.hydratMine.levelUp();
        }
        else if (name.equals("ether mine")){
            resources.substractCost(etherMine.getCost());
            this.etherMine.levelUp();
        }
        else if (name.equals("docks")){
            resources.substractCost(docks.getCost());
            this.docks.levelUp();
        }
        else if (name.equals("laboratory")) {
            resources.substractCost(laboratory.getCost());
            this.laboratory.levelUp();
        }
        else if (name.equals("power plant")) {
            resources.substractCost(powerPlant.getCost());
            this.powerPlant.levelUp();
        }
        else if (name.equals("shipyard")) {
            resources.substractCost(shipyard.getCost());
            this.shipyard.levelUp();
        }
        else if (name.equals("storage")) {
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
