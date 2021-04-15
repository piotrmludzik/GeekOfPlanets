import { Injectable } from '@angular/core';

declare var SockJS;
declare var Stomp;

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';

  stompClient = null;

  constructor() { }

  connect(): void {
    const socket = new SockJS('http://localhost:8080/space-game-websocket');

    this.stompClient = Stomp.over(socket);
    this.stompClient.connect({
      user : sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    }, (frame) => {
      // tslint:disable-next-line:only-arrow-functions typedef
      this.stompClient.subscribe('/user/queue/reply', (message) => {
        console.log('WebSocket | Retriever message: ' + JSON.parse(message.body).content);
      });
    });
  }

  sendMessage(): void {
    const message = JSON.stringify({
      playerName: sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME),
      targetX : 10,
      targetY : 7
    });
    this.stompClient.send('/app/playerMovement', {}, message);
  }

  disconnect(): void {
    this.stompClient.disconnect();
  }
}
