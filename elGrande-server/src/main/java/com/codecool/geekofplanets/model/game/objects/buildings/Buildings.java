package com.codecool.geekofplanets.model.game.objects.buildings;

import com.codecool.elgrande.model.game.Resources;
import com.codecool.elgrande.model.game.objects.buildings.mines.EtherMine;
import com.codecool.elgrande.model.game.objects.buildings.mines.HydratMine;
import com.codecool.elgrande.model.game.objects.buildings.mines.MetalMine;
import com.codecool.geekofplanets.model.game.objects.buildings.mines.EtherMine;
import com.codecool.geekofplanets.model.game.objects.buildings.mines.HydratMine;
import com.codecool.geekofplanets.model.game.objects.buildings.mines.MetalMine;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Component
@Entity
@Table(name="buildings")
public class Buildings {

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    private final transient EtherMine etherMine = new EtherMine();
    private final transient HydratMine hydratMine = new HydratMine();
    private final transient MetalMine metalMine = new MetalMine();
    private transient Docks docks;
    private final transient Laboratory laboratory = new Laboratory();
    private final transient PowerPlant powerPlant = new PowerPlant();
    private final transient Shipyard shipyard = new Shipyard();
    private final transient Storage storage = new Storage();
    private transient Resources extraction;
    private  transient final Building[] availableToBuild = new Building[9];

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
