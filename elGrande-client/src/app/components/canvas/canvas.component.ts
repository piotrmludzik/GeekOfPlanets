import {Component, ElementRef, HostListener, OnInit, ViewChild} from '@angular/core';

const gameBoardSetup = {
  boardFieldWidth: 36,
  boardFieldHeight: 18,
  fieldSize: 32,
  boardSize: {
    width: 1000,
    height: 1000,
  }
};
const x = 5;
const y = 5;
let moveDirection: string;
const spaceShip = {x: 0, y: 0};
const spaceShipImage = new Image();
spaceShipImage.src = '../assets/img/spaceShip_50.png';


@Component({
  selector: 'app-canvas',
  templateUrl: './canvas.component.html',
  styleUrls: ['./canvas.component.css']
})
export class CanvasComponent implements OnInit {



  constructor() { }
  @ViewChild('canvas', { static: true })
  canvas: ElementRef<HTMLCanvasElement>;

  private ctx: CanvasRenderingContext2D;
  @HostListener('window: keydown', ['$event'])
  // tslint:disable-next-line:typedef
  onKeypressEvent(event: KeyboardEvent) {
    this.convertDirection(event);
  }


  ngOnInit(): void {
    this.ctx = this.canvas.nativeElement.getContext('2d');
    const image = new Image();
    const canvas = this.ctx.canvas;
    canvas.width = gameBoardSetup.boardSize.width;
    canvas.height = gameBoardSetup.boardSize.height;
    this.drawSpaceship();
  }

  convertDirection(event: KeyboardEvent): any {
    const key = event.code;
    if (key === 'ArrowUp') {
      moveDirection = 'N';
    } else if (key === 'ArrowDown') {
      moveDirection = 'S';
    } else if (key === 'ArrowLeft') {
      moveDirection = 'W';
    } else if (key === 'ArrowRight') {
      moveDirection = 'E';
    }
    this.getNewPosition(spaceShip.x, spaceShip.y);
  }

  getNewPosition(playerX, playerY): any {
    if (moveDirection === 'W') {
      playerX -= gameBoardSetup.fieldSize;
    } else if (moveDirection === 'N') {
      playerY -= gameBoardSetup.fieldSize;
    } else if (moveDirection === 'E') {
      playerX += gameBoardSetup.fieldSize;
    } else if (moveDirection === 'S') {
      playerY += gameBoardSetup.fieldSize;
    }
    spaceShip.x = playerX;
    spaceShip.y = playerY;

    this.clearBoard();
    this.drawSpaceship();

    

    return spaceShip;
  }
  drawSpaceship( ): any{
    this.ctx.drawImage(spaceShipImage, spaceShip.x, spaceShip.y, spaceShipImage.width / 1 , spaceShipImage.height / 1 );
  }
  clearBoard(): void{
    this.ctx.clearRect(0, 0, gameBoardSetup.boardSize.width, gameBoardSetup.boardSize.height);
  }

}
