package com.codecool.elgrande.model.game.actors;

import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.game.objects.Planet;
import com.codecool.elgrande.model.game.FieldEntity;
import com.codecool.elgrande.model.game.technologies.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="users")
public class Player extends FieldEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private transient Field field;
    private transient Statistics statistics;
    private transient Planet planet;
    private transient Technology technologies;


    public Player() {
        super(null);
    }

    @Autowired
    public Player(Planet planet) {
        super(planet.getPosition());
        this.statistics = new Statistics(0,0,8);
        this.planet = planet;
        this.getField().setPlayer(this);
    }

    public Player(int id, String name, Field field, Planet planet) {
        super(field);
        super.setName(name);
        this.id = id;
        this.statistics = new Statistics(0,0,10);
        this.planet = planet;
        this.getField().setPlayer(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setCoordinates(Field field) {
        this.getField().setPlayer(this);
    }

    @Column(name="pos_x")
    public int getX() {
        return this.getField().getX();
    }

    @Column(name="pos_y")
    public int getY() {
        return this.getField().getY();
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return String.format("Player[id=%d, x=%d, y=%d]", id, this.getField().getX(), this.getField().getY());
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
