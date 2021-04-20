package com.codecool.geekofplanets.user.jdbc.controller;

import com.codecool.geekofplanets.game.logic.GameLogic;
import com.codecool.geekofplanets.network.dto.MessageDto;
import com.codecool.geekofplanets.user.jdbc.model.UserModel;
import com.codecool.geekofplanets.user.jdbc.service.UserService;
import com.codecool.geekofplanets.world.jdbc.service.PlayerService;
import com.codecool.geekofplanets.world.universe.actors.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final GameLogic gameLogic;
    private final PlayerService playerService;

    public UserController(UserService userService, GameLogic gameLogic, PlayerService playerService) {
        this.userService = userService;
        this.gameLogic = gameLogic;
        this.playerService = playerService;
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
        Player player = gameLogic.createPlayer(user.getUsername());
        playerService.addNewPlayer(player, user.getId());

        return new MessageDto("Hello registered");
    }
    

}
