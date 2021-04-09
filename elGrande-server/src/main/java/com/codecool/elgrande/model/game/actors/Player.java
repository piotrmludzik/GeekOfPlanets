package com.codecool.elgrande.model.game.actors;

import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.game.objects.Planet;
import com.codecool.elgrande.model.game.FieldEntity;
import com.codecool.elgrande.model.game.technologies.Technologies;
import com.codecool.elgrande.model.game.technologies.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="player")
public class Player extends FieldEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="pos_x")
    private int posX;

    @Column(name="pos_y")
    private int posY;

    private transient Field field;
    private transient Statistics statistics;
    private transient Planet planet;
    private transient Technologies technologies;


    public Player() {
        super(null);
    }

    @Autowired
    public Player(Planet planet) {
        super(planet.getPosition());
        this.statistics = new Statistics(0,0,8);
        this.planet = planet;
        this.getField().setPlayer(this);
        this.technologies = new Technologies();
    }

    public Player(int id, String name, Field field, Planet planet) {
        super(field);
        super.setName(name);
        this.id = id;
        this.statistics = new Statistics(0,0,10);
        this.planet = planet;
        this.technologies = new Technologies();
        this.getField().setPlayer(this);
    }

    public void visitPlanet(Planet planet){
        planet.visit();
    }

    public void discoverTechnologies(Technologies technologies, String technology){
        planet.discoverTechnologies(technologies, technology);
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

    public void setCoordinates(Field field) {
        this.getField().setPlayer(this);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = this.getField().getX();
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = this.getField().getY();
    }

    public void setField(Field field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return String.format("Player[id=%d, x=%d, y=%d]", id, this.getField().getX(), this.getField().getY());
    }

}
