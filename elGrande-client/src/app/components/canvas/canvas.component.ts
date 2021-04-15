import {Component, ElementRef, HostListener, OnInit, ViewChild} from '@angular/core';
import {WebsocketService} from '../../services/websocket.service';
import {GameService} from '../../services/game.service';

const x = 5;
const y = 5;
const spaceShipImage = new Image();
spaceShipImage.src = '../assets/img/spaceShip_50.png';


@Component({
  selector: 'app-canvas',
  templateUrl: './canvas.component.html',
  styleUrls: ['./canvas.component.css']
})
export class CanvasComponent implements OnInit {

  @ViewChild('canvas', { static: true })
  canvas: ElementRef<HTMLCanvasElement>;

  private ctx: CanvasRenderingContext2D;

  constructor(private websocket: WebsocketService, private gameService: GameService) { }

  ngOnInit(): void {
    this.ctx = this.canvas.nativeElement.getContext('2d');
    const image = new Image();
    const canvas = this.ctx.canvas;
    canvas.width = this.gameService.gameBoardSetup.boardSize.width;
    canvas.height = this.gameService.gameBoardSetup.boardSize.height;
    this.drawSpaceship();
  }

  @HostListener('window: keydown', ['$event'])
  // tslint:disable-next-line:typedef
  onKeypressEvent(event: KeyboardEvent) {
    if (this.isArrows(event)) {
      const moveDirection = this.convertDirection(event);
      this.websocket.sendMessage({direction: moveDirection});
    }
  }

  private isArrows(event: KeyboardEvent): any {
    switch (event.code) {
      case 'ArrowUp':
      case 'ArrowDown':
      case 'ArrowLeft':
      case 'ArrowRight':
        return true;
      default:
        return false;
    }
  }

  private convertDirection(event: KeyboardEvent): any {
    const key = event.code;
    if (key === 'ArrowUp') {
      return 'N';
    } else if (key === 'ArrowDown') {
      return 'S';
    } else if (key === 'ArrowLeft') {
      return 'W';
    } else if (key === 'ArrowRight') {
      return 'E';
    }

    return '';
  }

  refreshCanvas(): void {
    this.clearBoard();
    this.drawSpaceship();
  }

  private clearBoard(): void {
    this.ctx.clearRect(0, 0, this.gameService.gameBoardSetup.boardSize.width, this.gameService.gameBoardSetup.boardSize.height);
  }

  private drawSpaceship( ): any {
    this.ctx.drawImage(
      spaceShipImage,
      this.gameService.spaceShip.x,
      this.gameService.spaceShip.y,
      spaceShipImage.width / 4,
      spaceShipImage.height / 2);
  }
}
