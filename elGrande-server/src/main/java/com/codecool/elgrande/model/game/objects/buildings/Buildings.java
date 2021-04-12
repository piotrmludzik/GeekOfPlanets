package com.codecool.elgrande.model.game.objects.buildings;

import com.codecool.elgrande.model.game.Resources;
import com.codecool.elgrande.model.game.objects.buildings.mines.EtherMine;
import com.codecool.elgrande.model.game.objects.buildings.mines.HydratMine;
import com.codecool.elgrande.model.game.objects.buildings.mines.MetalMine;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="buildings")
public class Buildings {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private transient EtherMine etherMine;
    private transient HydratMine hydratMine;
    private transient MetalMine metalMine;
    private transient Docks docks;
    private transient Laboratory laboratory;
    private transient PowerPlant powerPlant;
    private transient Shipyard shipyard;
    private transient Storage storage;

    public Buildings() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
