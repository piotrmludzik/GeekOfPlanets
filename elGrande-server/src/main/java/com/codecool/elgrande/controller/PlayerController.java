package com.codecool.elgrande.controller;

import com.codecool.elgrande.dto.MessageDto;
import com.codecool.elgrande.game.logic.Direction;
import com.codecool.elgrande.game.logic.GameLogic;
import com.codecool.elgrande.game.model.actors.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private final GameLogic gameLogic;
    private final Player player;

    public PlayerController(GameLogic gameLogic, Player player) {
        this.gameLogic = gameLogic;
        this.player = player;
    }

    @GetMapping("/game")
    public MessageDto getPlayerOnBoard() {
        int id = player.getId();
        gameLogic.movePlayer(id, Direction.EAST);
        return new MessageDto("Player on the board");
    }
}
