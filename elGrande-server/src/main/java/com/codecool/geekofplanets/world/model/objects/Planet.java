package com.codecool.geekofplanets.world.model.objects;

import com.codecool.geekofplanets.world.model.Field;
import com.codecool.geekofplanets.world.model.FieldEntity;
import com.codecool.geekofplanets.world.model.Resources;
import com.codecool.geekofplanets.world.model.objects.buildings.Buildings;
import com.codecool.geekofplanets.world.model.technologies.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

@Component
public class Planet extends FieldEntity {
    private Resources resources;
    private String name;
    private boolean colonized = false;
    private Field field;
    private Buildings buildings;
    private LocalDate lastVisit;

    public Planet() {
        super(null);
    }

//    public Planet(Field field, Resources resources) {
//        super(field);
//        this.field = field;
//        this.resources = resources;
//    }

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
        this.field.setPlanet(this);
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

    public void setResources(Resources resources) {
        this.resources = resources;
    }
}
