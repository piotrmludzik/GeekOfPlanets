package com.codecool.elgrande.model.game.objects;

import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.game.FieldEntity;
import com.codecool.elgrande.model.game.Resources;
import com.codecool.elgrande.model.game.objects.buildings.*;
import com.codecool.elgrande.model.game.technologies.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;


@Component
public class Planet extends FieldEntity {
    private final Resources resources;
    private boolean colonized = false;
    private final Buildings buildings;
    private LocalDateTime lastVisit;

    @Autowired
    public Planet(Field position){
        super(position);
        this.getField().setPlanet(this);
        this.resources = new Resources(500, 500, 100, 0);
        this.buildings = new Buildings();
        this.lastVisit = LocalDateTime.now();
    }

    public void visit(){
        long time = java.time.Duration.between(lastVisit, LocalDateTime.now()).toSeconds();
        resources.extract(time, buildings.getExtraction());
        this.lastVisit = LocalDateTime.now();
    }

    public void discoverTechnologies(Technologies technologies, String technology){
        technologies.discover(technology, resources);
    }

    public boolean getColonized(){
        return colonized;
    }

    public void colonize(){
        this.colonized = true;
    }

    public void setName(String name){
        super.setName(name);
    }

    public Field getPosition() {
        return this.getField();
    }

    public void build(String name){
            buildings.buildNew(name, resources);
    }








}
