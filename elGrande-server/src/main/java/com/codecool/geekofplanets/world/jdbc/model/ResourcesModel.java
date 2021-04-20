package com.codecool.geekofplanets.world.jdbc.model;

import com.codecool.geekofplanets.world.universe.Resources;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name="resources")
public class ResourcesModel {
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name="metal")
    private int metal;

    @Column(name="hydrate")
    private int hydrate;

    @Column(name="ether")
    private int ether;

    @Column(name="antimatter")
    private int antimatter;

    public ResourcesModel() {
    }

    public ResourcesModel(Resources resources) {
        this.metal = resources.getMetal();
        this.hydrate = resources.getHydrate();
        this.ether = resources.getEther();
        this.antimatter = resources.getAntimatter();
    }
}
