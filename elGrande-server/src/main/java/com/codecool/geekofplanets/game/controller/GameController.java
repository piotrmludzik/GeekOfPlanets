package com.codecool.geekofplanets.game.controller;

import com.codecool.geekofplanets.game.logic.Direction;
import com.codecool.geekofplanets.game.logic.GameLogic;
import com.codecool.geekofplanets.network.websocket.controller.WebSocketController;
import com.codecool.geekofplanets.network.websocket.messages.ClientMsg;
import com.codecool.geekofplanets.network.websocket.messages.ServerMsg;
import com.codecool.geekofplanets.user.jdbc.model.UserModel;
import com.codecool.geekofplanets.user.jdbc.service.UserService;
import com.codecool.geekofplanets.world.jdbc.service.PlayerService;
import com.codecool.geekofplanets.world.universe.actors.Player;
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
    private GameLogic gameLogic;
    private WebSocketController webSocketController;

    @Autowired
    public GameController(UserService userService, PlayerService playerService, GameLogic gameLogic, WebSocketController webSocketController) {
        this.userService = userService;
        this.playerService = playerService;
        this.gameLogic = gameLogic;
        this.webSocketController = webSocketController;
    }

    public List<Player> getCurrentPlayers() {
        return currentPlayers;
    }

    public Player getPlayer(String playerName) {
        for(Player player : currentPlayers)
            if (player.getName().equals(playerName))
                return player;

        return null; // TODO throw exception;
    }

    public void setPlayer(String userName) {
        UserModel user = userService.getUserByUsername(userName);
        Player player = playerService.getPlayerByUserId(user.getId());

        currentPlayers.add(player);
    }

    public void receiveMessage(String playerName, ClientMsg clientMsg) {
        movePlayer(playerName, clientMsg);
    }

    private void movePlayer(String playerName, ClientMsg clientMsg) {
        Player player = getPlayer(playerName);
        gameLogic.movePlayer(player, Direction.getDirection(clientMsg.getDirection()));
        webSocketController.sendMessage(new ServerMsg());
        player.setFieldsInView(gameLogic.getFieldsInView(player));
    }
}
