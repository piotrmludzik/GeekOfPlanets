package com.codecool.elgrande.model.game.objects;

import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.game.FieldEntity;
import com.codecool.elgrande.model.game.Resources;
import com.codecool.elgrande.model.game.objects.buildings.Buildings;
import com.codecool.elgrande.model.game.technologies.Technologies;
import com.codecool.elgrande.model.game.technologies.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;

@Component
@Entity
@Table(name="planets")
public class Planet extends FieldEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

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

    private transient Resources resources;


    public Planet() {
        super(null);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
