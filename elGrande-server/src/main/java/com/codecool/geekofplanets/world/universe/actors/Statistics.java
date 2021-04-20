package com.codecool.geekofplanets.world.universe.actors;

import com.codecool.geekofplanets.world.jdbc.model.StatisticsModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Statistics {
    private int attack;
    private int defence;
    private int radius;

    @Autowired
    public Statistics() {
    }

    public Statistics(int attack, int defence, int radius){
        this.attack = attack;
        this.defence = defence;
        this.radius = radius;
    }

    public Statistics(StatisticsModel statisticsModel){
        this.attack = statisticsModel.getAttack();
        this.defence = statisticsModel.getDefence();
        this.radius = statisticsModel.getDefence();
    }
}
