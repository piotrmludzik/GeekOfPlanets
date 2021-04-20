package com.codecool.geekofplanets.world.jdbc.controller;

import com.codecool.geekofplanets.game.logic.GameLogic;
import com.codecool.geekofplanets.network.dto.MessageDto;
import com.codecool.geekofplanets.world.jdbc.service.PlayerService;
import com.codecool.geekofplanets.world.universe.actors.Player;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private final GameLogic gameLogic;
    private final Player player;
    private final PlayerService playerService;

    public PlayerController(GameLogic gameLogic, Player player, PlayerService playerService) {
        this.gameLogic = gameLogic;
        this.player = player;
        this.playerService = playerService;
    }

    @PostMapping("/dashboard")
    public MessageDto changePlayerName(String newName) {
        playerService.changePlayerName(newName);
        return new MessageDto("Player's dashboard'");
    }
}
