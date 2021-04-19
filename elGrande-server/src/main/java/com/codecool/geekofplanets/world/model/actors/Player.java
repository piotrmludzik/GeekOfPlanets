package com.codecool.geekofplanets.world.model.actors;

import com.codecool.geekofplanets.world.model.Field;
import com.codecool.geekofplanets.world.model.FieldEntity;
import com.codecool.geekofplanets.world.model.objects.Planet;
import com.codecool.geekofplanets.world.model.technologies.Technologies;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.UUID;

@Component
@Getter
@Setter
@Entity
@Table(name="player")
public class Player extends FieldEntity {
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name="name")
    private String name;

    @Setter(AccessLevel.NONE)
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
    private UUID userId;

    private transient Planet planet;

    public Player() {
        super(null);
    }

    public void discoverTechnology(String name){
        planet.discoverTechnology(technologies, name);
    }

    @Autowired
    public Player(Planet planet) {
        super(planet.getField());
        this.statistics = new Statistics(0,0,8);
        this.planet = planet;
    }

    public void setField(Field field) {
        this.field = field;
        this.field.setPlayer(this);
    }
}
