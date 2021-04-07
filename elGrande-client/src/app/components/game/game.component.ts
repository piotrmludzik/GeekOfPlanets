import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { GameService} from './game.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  welcomeMessage = '';
  isResponse = false;

  constructor(private route: ActivatedRoute, private router: Router, private gameService: GameService)  { }

  ngOnInit(): void {
    this.gameService.executeGameService().subscribe((res) => {
      console.log("result: " + res.message)
      this.isResponse = true;
      this.welcomeMessage = res.message;
    });
  }
}
