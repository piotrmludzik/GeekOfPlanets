import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { GameService} from './game.service';

declare var SockJS;
declare var Stomp;

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser';

  stompClient = null;
  welcomeMessage = '';
  isResponse = false;

  constructor(private route: ActivatedRoute, private router: Router, private gameService: GameService)  { }

  ngOnInit(): void {
    this.gameService.executeGameService().subscribe((res) => {
      console.log('result: ' + res.message);
      this.isResponse = true;
      this.welcomeMessage = res.message;
    });

    this.connect();
  }

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
}
