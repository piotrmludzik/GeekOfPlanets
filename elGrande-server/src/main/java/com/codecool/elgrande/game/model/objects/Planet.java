package com.codecool.elgrande.game.model.objects;

import com.codecool.elgrande.game.model.Field;
import com.codecool.elgrande.game.model.FieldEntity;
import com.codecool.elgrande.game.model.objects.buildings.Buildings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

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

    public Planet() {
        super(null);
    }

    @Autowired
    public Planet(Field position){
        super(position);
    }

    public boolean isColonized() {
        return colonized;
    }

    public void setColonized(boolean colonized) {
        this.colonized = true;
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
}
