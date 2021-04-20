package com.codecool.geekofplanets.user.jdbc.controller;

import com.codecool.geekofplanets.game.logic.GameLogic;
import com.codecool.geekofplanets.network.dto.MessageDto;
import com.codecool.geekofplanets.user.jdbc.service.UserService;
import com.codecool.geekofplanets.user.model.User;
import com.codecool.geekofplanets.world.universe.Field;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;
    private final GameLogic gameLogic;

    public UserController(UserService userService, GameLogic gameLogic) {
        this.userService = userService;
        this.gameLogic = gameLogic;
    }

    @GetMapping("/")
    public MessageDto hello() {
        return new MessageDto("Hello world");
    }

    @GetMapping("/secured")
    public MessageDto helloSecured() {
        return new MessageDto("Hello secured");
    }

    @PostMapping("/register")
    public MessageDto handleUserForm(@RequestBody User user) {
        user.setEnabled(1);
        userService.addNewUser(user);
        UUID id = userService.getUserByUsername(user.getUsername()).getId();
        Field field = new Field(2, 2);
        gameLogic.createPlayer(user.getUsername(), field, id);

        return new MessageDto("Hello registered");
    }
}
