import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GameService {

// NOTE: for development
  gameBoardSetup = {
    boardFieldWidth: 36,
    boardFieldHeight: 18,
    fieldSize: 32,
    boardSize: {
      width: 1000,
      height: 1000,
    }
  };

  moveDirection: string;
  spaceShip = {x: 0, y: 0};

  constructor() { }

  movePlayer(message): void {
    this.spaceShip.x = message.targetX;
    this.spaceShip.y = message.targetY;
    //
    // this.getNewPosition(message.targetX, message.targetY);
  }

  // private getNewPosition(playerX, playerY): any {
  //
  //   if (this.moveDirection === 'W') {
  //     playerX -= this.gameBoardSetup.fieldSize;
  //   } else if (this.moveDirection === 'N') {
  //     playerY -= this.gameBoardSetup.fieldSize;
  //   } else if (this.moveDirection === 'E') {
  //     playerX += this.gameBoardSetup.fieldSize;
  //   } else if (this.moveDirection === 'S') {
  //     playerY += this.gameBoardSetup.fieldSize;
  //   }
  //   this.spaceShip.x = playerX;
  //   this.spaceShip.y = playerY;
  //
  //   return this.spaceShip;  // NOTE: check it.
  // }
}
