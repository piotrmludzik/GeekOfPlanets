package com.codecool.geekofplanets.world.universe.actors;

import com.codecool.geekofplanets.world.universe.Field;
import com.codecool.geekofplanets.world.universe.FieldEntity;
import com.codecool.geekofplanets.world.universe.objects.Planet;
import com.codecool.geekofplanets.world.universe.technologies.Technologies;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Getter
@Setter

public class Player extends FieldEntity {
    private UUID id;
    @Setter(AccessLevel.NONE)
    private Statistics statistics;
    private Technologies technologies;
    private UUID userId;
    private Planet planet;

    public Player() {
        super(null);
    }

    @Autowired
    public Player(Planet planet) {
        super(planet.getField());
        this.statistics = new Statistics(0,0,8);
        this.planet = planet;
    }

    public void setOnField(Field field) {
        super.setField(field);
        super.getField().setPlayer(this);
    }

    public void discoverTechnology(String name){
        planet.discoverTechnology(technologies, name);
    }
}