package com.codecool.elgrande.model.game.actors;

import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.game.FieldEntity;
import com.codecool.elgrande.model.game.objects.Planet;
import com.codecool.elgrande.model.game.technologies.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

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

    @OneToOne
    @JoinColumn(name="field_id", referencedColumnName="id")
    private Field field;

    @OneToOne
    @JoinColumn(name="statistics_id", referencedColumnName="id")
    private Statistics statistics;

    private transient Planet planet;

    @OneToMany(mappedBy="player", cascade=CascadeType.REMOVE, orphanRemoval=true)
    private Set<Technologies> technologies;

    public Player() {
        super(null);
    }

    @Autowired
    public Player(Planet planet) {
        super(planet.getField());
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

    @Override
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Set<Technologies> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<Technologies> technologies) {
        this.technologies = technologies;
    }

    @Override
    public String toString() {
        return String.format("Player[id=%d, x=%d, y=%d]", id, this.getField().getX(), this.getField().getY());
    }
}
