package com.codecool.elgrande.model.game.actors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="attack")
    private int attack;

    @Column(name="defence")
    private int defence;

    @Column(name="radius")
    private int radius;

    @Autowired
    public Statistics() {
    }

    public Statistics(int attack, int defence, int radius){
        this.attack = attack;
        this.defence = defence;
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getRadius() {
        return radius;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
