package com.codecool.elgrande.model;

import com.codecool.elgrande.model.technologie.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="user")
public class Player extends SpaceObject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private transient String name;
    private transient Field field;
    private transient Statistics statistics;
    private transient Planet planet;
    private transient Technology technologies;

    @Autowired
    public Player() {
        this.getField().setPlayer(this);
    }

    public Player(int id, String name, Field field, Planet planet) {
        super(field, name);
        this.id = id;
        this.statistics = new Statistics(0,0,10);
        this.planet = planet;
        this.getField().setPlayer(this);
    }

    public Player(int id, String name, Planet planet ) {
        super(planet.getPosition(), name);
        this.id = id;
        this.statistics = new Statistics(0,0,8);
        this.planet = planet;
        this.getField().setPlayer(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoordinates(Field field) {
        this.getField().setPlayer(this);

    @Column(name="pos_x")
    public int getX() {
        return field.getX();
    }

    @Column(name="pos_y")
    public int getY() {
        return field.getY();
    }

    @Override
    public String toString() {
        return String.format("Actor[id=%d, x=%d, y=%d]", id, this.getField().getX(), this.getField().getY());
    }

    public static class Statistics {
        private int attack;
        private int defence;
        private int radius;

        public Statistics(int attack, int defence, int radius){
            this.attack = attack;
            this.defence = defence;
            this.radius = radius;
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
}
