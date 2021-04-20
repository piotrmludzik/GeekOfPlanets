package com.codecool.geekofplanets.game.controller;

import com.codecool.geekofplanets.user.jdbc.model.UserModel;
import com.codecool.geekofplanets.user.jdbc.service.UserService;
import com.codecool.geekofplanets.world.jdbc.service.PlayerService;
import com.codecool.geekofplanets.world.model.actors.Player;
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
        UserModel user = userService.getUserByUsername(userName);
        Player player = playerService.getPlayerByUserId(user.getId());

        currentPlayers.add(player);
    }
}
