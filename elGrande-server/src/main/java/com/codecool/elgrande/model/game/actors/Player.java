package com.codecool.elgrande.model.game.actors;

import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.game.FieldEntity;
import com.codecool.elgrande.model.game.objects.Planet;
import com.codecool.elgrande.model.game.technologies.Technologies;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
@Entity
@Table(name="player")
public class Player extends FieldEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="field_id", referencedColumnName="id")
    private Field field;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="statistics_id", referencedColumnName="id")
    private Statistics statistics;

    private transient Planet planet;

    @JsonIgnore
    @OneToMany(fetch=FetchType.EAGER, mappedBy="player", cascade={CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, orphanRemoval=true)
    private List<Technologies> technologies;

    public Player() {
        super(null);
    }

    @Autowired
    public Player(Planet planet) {
        super(planet.getField());
        this.statistics = new Statistics(0,0,8);
        this.planet = planet;
    }

    public void setCoordinates(Field field) {
        this.getField().setPlayer(this);
    }

    public void add(Technologies tempTechnologies) {
        if (technologies == null) {
            technologies = new ArrayList<>();
        }
        technologies.add(tempTechnologies);
        tempTechnologies.setPlayer(this);
    }
}
