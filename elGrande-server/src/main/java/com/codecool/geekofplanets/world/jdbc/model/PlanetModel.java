package com.codecool.geekofplanets.world.jdbc.model;

import com.codecool.geekofplanets.world.universe.objects.Planet;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Component
@Setter
@Getter
@Entity
@Table(name="planets")
public class PlanetModel {
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="field_id", referencedColumnName="id")
    private FieldModel field;

    @Column(name="name")
    private String name;

    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="resources_id", referencedColumnName="id")
    private ResourcesModel resources;

    @Column(name="is_colonized")
    private boolean colonized = false;

    @OneToOne(cascade= CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="buildings_id", referencedColumnName="id")
    private BuildingsModel buildings;

    @Column(name="last_visit")
    private LocalDate lastVisit;

    @Autowired
    public PlanetModel() {
    }

    public PlanetModel(Planet planet) {
        this.field = new FieldModel(planet.getField());
        this.name = planet.getName();
        this.resources = new ResourcesModel(planet.getResources());
        this.colonized = planet.isColonized();
        this.buildings = new BuildingsModel(planet.getBuildings());
        this.lastVisit = planet.getLastVisit();
    }
}
