import { Injectable } from '@angular/core';
import {GameService} from './game.service';

declare var SockJS;
declare var Stomp;

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';

  stompClient = null;

  constructor(private gameService: GameService) { }

  connect(): void {
    const socket = new SockJS('http://localhost:8080/space-game-websocket');

    this.stompClient = Stomp.over(socket);
    this.stompClient.connect({
      user : sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    }, (frame) => {
      // tslint:disable-next-line:only-arrow-functions typedef
      this.stompClient.subscribe('/user/queue/reply', (message) => {
        const msg = JSON.parse(message.body).content;
        console.log('WebSocket | Retriever message: ' + msg);  // NOTE: dev code
        this.messageController(msg);
      });
    });
  }

  messageController(message): void {
    this.gameService.movePlayer(message);
  }

  sendMessage(message): void {
    this.stompClient.send('/app/playerMovement', {}, JSON.stringify(message));
  }

  disconnect(): void {
    this.stompClient.disconnect();
  }
}
