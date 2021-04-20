package com.codecool.geekofplanets.world.model.actors;

import com.codecool.geekofplanets.world.model.Field;
import com.codecool.geekofplanets.world.model.FieldEntity;
import com.codecool.geekofplanets.world.model.objects.Planet;
import com.codecool.geekofplanets.world.model.technologies.Technologies;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Player extends FieldEntity {
    private String name;
    private Field field;
    private Statistics statistics;
    private Technologies technologies;

    private transient Planet planet;

    public Player(Field field, String name) {
        super(field);
        this.name = name;
    }

    @Autowired
    public Player(Planet planet) {
        super(planet.getField());
        this.statistics = new Statistics(0,0,8);
        this.planet = planet;
    }

    public void discoverTechnology(String name){
        planet.discoverTechnology(technologies, name);
    }

    public void setField(Field field) {
        this.field = field;
        this.field.setPlayer(this);
    }
}
