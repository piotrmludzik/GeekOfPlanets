package com.codecool.geekofplanets.world.model.objects;

import com.codecool.geekofplanets.world.model.Field;
import com.codecool.geekofplanets.world.model.FieldEntity;
import com.codecool.geekofplanets.world.model.Resources;
import com.codecool.geekofplanets.world.model.objects.buildings.Buildings;
import com.codecool.geekofplanets.world.model.technologies.Technologies;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

@Component
@Entity
@Table(name="planets")
public class Planet extends FieldEntity {

    private transient Resources resources;

    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="is_colonized")
    private boolean colonized = false;

    @OneToOne
    @JoinColumn(name="field_id", referencedColumnName="id")
    private Field field;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="buildings_id", referencedColumnName="id")
    private Buildings buildings;

    private LocalDate lastVisit;

    public Planet() {
        super(null);
    }

    public Planet(Field field, Resources resources) {
        super(field);
        this.resources =  new Resources(1000,500,200,0);
    }

    public void newVisit(){
        long duration = Duration.between(LocalDate.now(), lastVisit).toSeconds();
        this.resources.extract(duration, buildings.getExtraction());
        this.lastVisit = LocalDate.now();
    }

    @Autowired
    public Planet(Field position){
        super(position);
    }

    public boolean isColonized() {
        return colonized;
    }

    public void colonize(){
        this.colonized = true;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public Field getField() {
        return field;
    }

    public Buildings getBuildings() {
        return buildings;
    }

    public void setBuildings(Buildings buildings) {
        this.buildings = buildings;
    }

    public void discoverTechnology(Technologies technologies, String name){
        technologies.discover(name, resources);
    }
}
