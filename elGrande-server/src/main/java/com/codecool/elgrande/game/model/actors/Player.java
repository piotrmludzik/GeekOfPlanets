package com.codecool.elgrande.game.model.actors;

import com.codecool.elgrande.game.model.Field;
import com.codecool.elgrande.game.model.FieldEntity;
import com.codecool.elgrande.game.model.objects.Planet;
import com.codecool.elgrande.game.model.technologies.Technologies;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

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

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="technologies_id", referencedColumnName="id")
    private Technologies technologies;

    @Column(name="user_id")
    private int userId;

    private transient Planet planet;

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
}
