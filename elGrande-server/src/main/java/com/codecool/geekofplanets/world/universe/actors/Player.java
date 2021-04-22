package com.codecool.geekofplanets.world.universe.actors;

import com.codecool.geekofplanets.world.jdbc.model.PlayerModel;
import com.codecool.geekofplanets.world.universe.Field;
import com.codecool.geekofplanets.world.universe.FieldEntity;
import com.codecool.geekofplanets.world.universe.objects.Planet;
import com.codecool.geekofplanets.world.universe.technologies.Technologies;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
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
    private List<Field> FieldsInView = new LinkedList<>();

    public Player() {
        super(null);
    }

    @Autowired
    public Player(Planet planet) {
        super(planet.getField());
        this.statistics = new Statistics(0,0,1);
        this.planet = planet;
    }

//    public Player(Field field, UUID id, Statistics statistics, Technologies technologies, UUID userId, Planet planet) {
//        super(field);
//        this.id = id;
//        this.statistics = statistics;
//        this.technologies = technologies;
//        this.userId = userId;
//        this.planet = planet;
//    }

    public Player(PlayerModel playerModel) {
        super(new Field(playerModel.getField()), playerModel.getName());
        this.statistics = new Statistics(playerModel.getStatistics());
        this.technologies = new Technologies(playerModel.getTechnologies());
        this.userId = playerModel.getUserId();
        this.planet = new Planet(playerModel.getPlanet());
    }

    public void setOnField(Field field) {
        super.setField(field);
        super.getField().setPlayer(this);
    }

    public void discoverTechnology(String name){
        planet.discoverTechnology(technologies, name);
    }
}
