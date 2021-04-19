package com.codecool.geekofplanets.controller;

import com.codecool.elgrande.dto.MessageDto;
import com.codecool.elgrande.jdbc.service.game.PlayerService;
import com.codecool.elgrande.logic.Direction;
import com.codecool.elgrande.logic.GameLogic;
import com.codecool.elgrande.model.game.actors.Player;
import com.codecool.geekofplanets.dto.MessageDto;
import com.codecool.geekofplanets.logic.GameLogic;
import org.springframework.web.bind.annotation.GetMapping;
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
