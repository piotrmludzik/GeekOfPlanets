package com.codecool.elgrande.websocket;

import com.codecool.elgrande.logic.GameLogic;
import com.codecool.elgrande.websocket.messages.ClientPlayerMovement;
import com.codecool.elgrande.websocket.messages.ServerPlayerMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WebSocketController {
    private final SimpMessagingTemplate messagingTemplate;
    //    private final GameLogic gameLogic;

    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/playerMovement")
    public void greeting(Principal principal, ClientPlayerMovement clientPlayerMovement) throws  Exception {
        System.out.println("WebSocket | " + clientPlayerMovement);  // NOTE: dev code: console log
//        gameLogic.movePlayer(clientPlayerMovement.getPlayerId(), clientPlayerMovement.getDirection());
//        Player movingPlayer = gameLogic.getPlayer(clientPlayerMovement.getPlayerId());
//        ServerPlayerMovement serverPlayerMovement = new ServerPlayerMovement(movingPlayer.getId(), movingPlayer.getX(), movingPlayer.getY());

        ServerPlayerMovement serverPlayerMovement = new ServerPlayerMovement(clientPlayerMovement.getPlayerName(), clientPlayerMovement.getTargetX(), clientPlayerMovement.getTargetY());

//        System.out.println("WebSocket | " + serverPlayerMovement);  // NOTE: dev code: console log
        messagingTemplate.convertAndSendToUser("user", "/queue/reply", serverPlayerMovement);  // NOTE: fixed user2 destination
    }

//    NOTE: the code below is an example for sending messages to all active clients
//    @MessageMapping("/playerMovement")
//    @SendTo("/topic/playerMovement")
//    public ServerPlayerMovement receiveUserEventData(ClientPlayerMovement clientPlayerMovement) {
//        System.out.println("WebSocket | " + clientPlayerMovement);  // NOTE: dev code: console log
//        var serverPlayerMovement = new ServerPlayerMovement(0, 0, 0);
//        System.out.println("WebSocket | " + serverPlayerMovement);  // NOTE: dev code: console log
//        return serverPlayerMovement;
//    }
}
