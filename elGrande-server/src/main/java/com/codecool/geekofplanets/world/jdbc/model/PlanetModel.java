package com.codecool.geekofplanets.world.jdbc.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
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

    @Column(name="name")
    private String name;

    @Column(name="is_colonized")
    private boolean colonized = false;

    @OneToOne
    @JoinColumn(name="field_id", referencedColumnName="id")
    private FieldModel field;

    @OneToOne(cascade= CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="buildings_id", referencedColumnName="id")
    private BuildingsModel buildings;

    @Autowired
    public PlanetModel() {
    }
}
