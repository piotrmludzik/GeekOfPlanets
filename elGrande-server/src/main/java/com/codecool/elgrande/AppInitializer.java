package com.codecool.elgrande;

import com.codecool.elgrande.logic.GameLogic;
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
        gameLogic.createPlayer("Boris");
    }
}
