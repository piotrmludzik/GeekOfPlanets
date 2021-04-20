package com.codecool.geekofplanets.world.jdbc.model;

import com.codecool.geekofplanets.world.universe.actors.Player;
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
public class PlayerModel {
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name="name")
    private String name;

    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="field_id", referencedColumnName="id")
    private FieldModel field;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="statistics_id", referencedColumnName="id")
    private StatisticsModel statistics;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="technologies_id", referencedColumnName="id")
    private TechnologiesModel technologies;

    @OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="planet_id", referencedColumnName="id")
    private PlanetModel planet;

    @Column(name="user_id")
    private UUID userId;

    @Autowired
    public PlayerModel() {
    }

    public PlayerModel(Player player) {
        this.name = player.getName();
        this.field = new FieldModel(player.getField());
        this.statistics = new StatisticsModel(player.getStatistics());
        this.technologies = new TechnologiesModel(player.getTechnologies());
        this.planet = new PlanetModel(player.getPlanet());
        this.userId = player.getUserId();
    }
}
