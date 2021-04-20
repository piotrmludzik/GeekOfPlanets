package com.codecool.geekofplanets.user.jdbc.controller;

import com.codecool.geekofplanets.network.dto.MessageDto;
import com.codecool.geekofplanets.user.jdbc.model.UserModel;
import com.codecool.geekofplanets.user.jdbc.service.UserService;
import com.codecool.geekofplanets.world.jdbc.service.FieldService;
import com.codecool.geekofplanets.world.jdbc.service.PlayerService;
import com.codecool.geekofplanets.world.model.Field;
import com.codecool.geekofplanets.world.model.actors.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;
    private final PlayerService playerService;
    private final FieldService fieldService;

    public UserController(UserService userService, PlayerService playerService, FieldService fieldService) {
        this.userService = userService;
        this.playerService = playerService;
        this.fieldService = fieldService;
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
    public MessageDto handleUserForm(@RequestBody UserModel user) {
        user.setEnabled(1);
        userService.addNewUser(user);
        UUID id = user.getId();
        Field field = new Field(0, 0);
        Player player = new Player(field, user.getUsername());
        playerService.addNewPlayer(player, id);

        return new MessageDto("Hello registered");
    }
}
