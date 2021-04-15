package com.codecool.elgrande.controller;

import com.codecool.elgrande.jdbc.service.game.PlayerService;
import com.codecool.elgrande.jdbc.service.user.UserService;
import com.codecool.elgrande.model.game.actors.Player;
import com.codecool.elgrande.model.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Component
public class GameController {
    private UserService userService;
    private PlayerService playerService;

    private final List<Player> currentPlayers = new LinkedList<>();

    @Autowired
    public GameController(UserService userService, PlayerService playerService) {
        this.userService = userService;
        this.playerService = playerService;
    }

    public List<Player> getCurrentPlayers() {
        return currentPlayers;
    }

    public Player getPlayer(String playerName) {
        for(Player player : currentPlayers)
            if (player.getName().equals(playerName))
                return player;

        return null;
    }

    public void setPlayer(String userName) {
        User user = userService.getUserByUsername(userName);
        Player player = playerService.getPlayerByUserId(user.getId());

        currentPlayers.add(player);
    }
}
