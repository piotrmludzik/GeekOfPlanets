import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
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


function gameLoop(timeStamp): void {
  this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);

  const image = new Image();
  image.onload = () => {
    this.ctx.drawImage(image, 0, 0, image.width / 2, image.height / 2);
  };
}

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


  ngOnInit(): void {
    requestAnimationFrame(gameLoop);
  }

  ngAfterViewInit(): void {
    this.init();
  }

  init(): void {
    this.ctx = this.canvas.nativeElement.getContext('2d');
    const image = new Image();
    const canvas = this.ctx.canvas;
    canvas.width = gameBoardSetup.boardSize.width;
    canvas.height = gameBoardSetup.boardSize.height;



  }
  moveRight(): void{
    const image = new Image();
    image.onload = () => {
      this.ctx.drawImage(image, 0, 0, image.width / 2, image.height / 2);
    };
    image.src = '../assets/spaceShip.png';
    const canvas = this.ctx.canvas;
    this.ctx.clearRect(0, 0,  canvas.width, canvas.height);
    this.ctx.drawImage(image, 0, 0, image.width / 2, image.height / 2);
    this.ctx.translate(x + 15, 0);
    this.ctx.restore();

  }

  moveLeft(): void{
    const image = new Image();
    image.onload = () => {
      this.ctx.drawImage(image, 0, 0, image.width / 2, image.height / 2);
    };
    image.src = '../assets/spaceShip.png';
    const canvas = this.ctx.canvas;
    this.ctx.clearRect(0, 0,  canvas.width, canvas.height);
    this.ctx.drawImage(image, 0, 0, image.width / 2, image.height / 2);
    this.ctx.rotate(45 * Math.PI / 180);

    this.ctx.translate(-15, 0);
    this.ctx.restore();

  }


}
