package com.codecool.elgrande;

import com.codecool.elgrande.logic.GameLogic;
import com.codecool.elgrande.model.game.Field;
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
    public void init() {
        Field field = new Field(8, 2);
        gameLogic.createPlayer("djjhkfj", field);

        User user = new User("xoip", "xoip");
        gameLogic.createUser(user, 12);

        gameLogic.getAllUsers();
    }
}
