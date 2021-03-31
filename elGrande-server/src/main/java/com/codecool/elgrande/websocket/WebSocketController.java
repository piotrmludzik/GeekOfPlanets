package com.codecool.elgrande.websocket;

import com.codecool.elgrande.logic.GameLogic;
import com.codecool.elgrande.model.Player;
import com.codecool.elgrande.websocket.messages.ClientPlayerMovement;
import com.codecool.elgrande.websocket.messages.ServerPlayerMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
    private final GameLogic gameLogic;

    @Autowired
    public WebSocketController(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    // ------------------------------------------- Messages from a clients --------------------------------------------

    @MessageMapping("/playerMovement")
    @SendTo("/websocket/playerMovement")
    public ServerPlayerMovement receiveUserEventData(ClientPlayerMovement clientPlayerMovement) {
        System.out.println("WebSocket | Received user movement message from client: " + clientPlayerMovement);  // NOTE: dev code: console log
        gameLogic.movePlayer(clientPlayerMovement.getPlayerId(), clientPlayerMovement.getDirection());
        Player movingPlayer = gameLogic.getPlayer(clientPlayerMovement.getPlayerId());
        ServerPlayerMovement serverPlayerMovement = new ServerPlayerMovement(movingPlayer.getId(), movingPlayer.getX(), movingPlayer.getY());
        return serverPlayerMovement;
    }

    // -------------------------------------------- Messages from a server --------------------------------------------

//    @SendTo("/websocket/playerMovement")
//    public ServerPlayerMovement sendGameData(ServerPlayerMovement serverPlayerMovement) {
//        System.out.println("WebSocket | Send the player movement position to the clients: " + serverPlayerMovement);  // NOTE: dev code: console log
//        return serverPlayerMovement;
//    }
}