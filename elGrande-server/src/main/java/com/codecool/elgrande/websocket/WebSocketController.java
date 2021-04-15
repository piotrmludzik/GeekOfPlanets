package com.codecool.elgrande.websocket;

import com.codecool.elgrande.controller.GameController;
import com.codecool.elgrande.logic.Direction;
import com.codecool.elgrande.logic.GameLogic;
import com.codecool.elgrande.model.game.actors.Player;
import com.codecool.elgrande.websocket.messages.ClientPlayerMovement;
import com.codecool.elgrande.websocket.messages.ServerPlayerMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WebSocketController {
    private final GameController gameController;
    private final GameLogic gameLogic;

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketController(GameController gameController, GameLogic gameLogic, SimpMessagingTemplate messagingTemplate) {
        this.gameController = gameController;
        this.messagingTemplate = messagingTemplate;
        this.gameLogic = gameLogic;
    }

    @MessageMapping("/playerMovement")
    public void greeting(Principal principal, ClientPlayerMovement clientPlayerMovement) throws  Exception {
        System.out.println("WebSocket | " + clientPlayerMovement);  // NOTE: dev code: console log

        gameLogic.movePlayer(principal.getName(), Direction.getDirection(clientPlayerMovement.getDirection()));
        Player movingPlayer = gameController.getPlayer(principal.getName());
        ServerPlayerMovement serverPlayerMovement = new ServerPlayerMovement(movingPlayer.getName(), movingPlayer.getField().getX(), movingPlayer.getField().getY());

        System.out.println("WebSocket | " + serverPlayerMovement);  // NOTE: dev code: console log
        messagingTemplate.convertAndSendToUser(movingPlayer.getName(), "/queue/reply", serverPlayerMovement);
    }
}
