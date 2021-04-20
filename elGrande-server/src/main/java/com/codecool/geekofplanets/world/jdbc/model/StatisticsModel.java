package com.codecool.geekofplanets.world.jdbc.model;

import com.codecool.geekofplanets.world.universe.actors.Statistics;
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
@Table(name="statistics")
public class StatisticsModel {
    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name="attack")
    private int attack;

    @Column(name="defence")
    private int defence;

    @Column(name="radius")
    private int radius;

    @Autowired
    public StatisticsModel() {
    }

    public StatisticsModel(Statistics statistics) {
        this.attack = statistics.getAttack();
        this.defence = statistics.getDefence();
        this.radius = statistics.getRadius();
    }
}
