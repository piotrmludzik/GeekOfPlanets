package com.codecool.elgrande.model.game.objects;

import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.game.FieldEntity;
import com.codecool.elgrande.model.game.objects.buildings.Buildings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(mappedBy="planet", cascade=CascadeType.REMOVE, orphanRemoval=true)
    private Set<Buildings> buildings;

    public Planet() {
        super(null);
    }

    @Autowired
    public Planet(Field position){
        super(position);
        this.getField().setPlanet(this);
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

    public Set<Buildings> getBuildings() {
        return buildings;
    }

    public void setBuildings(Set<Buildings> buildings) {
        this.buildings = buildings;
    }
}
