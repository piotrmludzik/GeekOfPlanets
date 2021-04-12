package com.codecool.elgrande;

import com.codecool.elgrande.logic.GameLogic;
import com.codecool.elgrande.model.user.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AppInitializer {
    private final GameLogic gameLogic;

    public AppInitializer(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    @PostConstruct
    public void init() throws Exception {
//        Field field = new Field(9, 1);
//        gameLogic.createPlayer("Blob", field);
//
        User user = new User("xox", "xox");
        gameLogic.createUser(user, 10);

        gameLogic.getAllUsers();
    }
}
