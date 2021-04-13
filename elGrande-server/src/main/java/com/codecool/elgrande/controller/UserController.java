package com.codecool.elgrande.controller;

import com.codecool.elgrande.dto.MessageDto;
import com.codecool.elgrande.jdbc.service.user.UserService;
import com.codecool.elgrande.logic.GameLogic;
import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.user.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// TODO: verify class name
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
        int id = userService.getUserByUsername(user.getUsername()).getId();
        Field field = new Field(2, 2);
        gameLogic.createPlayer(user.getUsername(), field, id);

        return new MessageDto("Hello registered");
    }
}
