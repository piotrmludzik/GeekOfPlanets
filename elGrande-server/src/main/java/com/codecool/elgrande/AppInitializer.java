package com.codecool.elgrande;

import com.codecool.elgrande.logic.GameLogic;
import com.codecool.elgrande.model.Cell;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AppInitializer {
    private final GameLogic gameLogic;

    public AppInitializer(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    @PostConstruct
    public void init() {
        gameLogic.createActor(1, new Cell(3,1));
        gameLogic.createActor(2, new Cell(17,10));
    }
}