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
//        Field field = new Field(5, 4);
//        Player player = gameLogic.createPlayer("Rick", field);
//
//        User user = new User("user7", "qwerty");
//        gameLogic.createUser(user, player.getId());
    }
}
