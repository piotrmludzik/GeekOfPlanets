package com.codecool.elgrande.model.game.objects.buildings;

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
}
