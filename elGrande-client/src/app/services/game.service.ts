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
      width: 36 * 32,
      height: 18 * 32,
    }
  };
  spaceShip = {x: 0, y: 0};

  constructor() { }

  movePlayer(message): void {
    this.spaceShip.x = message.targetX * 32;
    this.spaceShip.y = message.targetY * 32;
  }
}
