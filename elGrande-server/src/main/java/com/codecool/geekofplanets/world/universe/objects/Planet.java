package com.codecool.geekofplanets.world.universe.objects;

import com.codecool.geekofplanets.world.jdbc.model.PlanetModel;
import com.codecool.geekofplanets.world.universe.Field;
import com.codecool.geekofplanets.world.universe.FieldEntity;
import com.codecool.geekofplanets.world.universe.Resources;
import com.codecool.geekofplanets.world.universe.objects.buildings.Buildings;
import com.codecool.geekofplanets.world.universe.technologies.Technologies;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

@Getter
@Setter
@Component
public class Planet extends FieldEntity {
    private Resources resources;
    private boolean colonized = false;
    private Buildings buildings;
    private LocalDate lastVisit;

    public Planet() {
        super(null);
    }

    @Autowired
    public Planet(Field position){
        super(position);
    }

    public Planet(Field position, Resources resources) {
        super(position);
        this.resources = resources;
    }

    public Planet(PlanetModel planetModel) {
        super(new Field(planetModel.getField()), planetModel.getName());
        this.resources = new Resources(planetModel.getResources());
        this.colonized = planetModel.isColonized();
        this.buildings = new Buildings(planetModel.getBuildings());
        this.lastVisit = planetModel.getLastVisit();

    }

    public Planet(Field field, String name,
                  Resources resources, boolean colonized,
                  Buildings buildings, LocalDate lastVisit) {
        super(field, name);
        this.resources = resources;
        this.colonized = colonized;
        this.buildings = buildings;
        this.lastVisit = lastVisit;
    }

    public void newVisit(){
        long duration = Duration.between(LocalDate.now(), lastVisit).toSeconds();
        this.resources.extract(duration, buildings.getExtraction());
        this.lastVisit = LocalDate.now();
    }

    public boolean isColonized() {
        return colonized;
    }

    public void colonize(){
        this.colonized = true;
    }

    public void discoverTechnology(Technologies technologies, String name){
        technologies.discover(name, resources);
    }
}
