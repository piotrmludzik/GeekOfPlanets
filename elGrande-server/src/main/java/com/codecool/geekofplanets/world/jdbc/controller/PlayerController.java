package com.codecool.geekofplanets.world.jdbc.controller;

import com.codecool.geekofplanets.network.dto.MessageDto;
import com.codecool.geekofplanets.world.jdbc.service.PlayerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/dashboard")
    public MessageDto changePlayerName(String newName) {
        playerService.changePlayerName(newName);
        return new MessageDto("Player's dashboard'");
    }
}
