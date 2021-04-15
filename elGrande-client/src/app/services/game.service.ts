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
  spaceShip = {x: 0, y: 0};

  constructor() { }

  movePlayer(message): void {
    this.spaceShip.x = message.targetX;
    this.spaceShip.y = message.targetY;
  }
}
