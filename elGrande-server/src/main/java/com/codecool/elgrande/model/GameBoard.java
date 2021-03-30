package com.codecool.elgrande.model;

import com.codecool.elgrande.qualifier.BoardHeight;
import com.codecool.elgrande.qualifier.BoardWidth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class GameBoard {
    private Cell[][] board;
    private final int height;
    private final int width;

    @Autowired
    public GameBoard(@BoardHeight int height, @BoardWidth int width) {
        this.height = height;
        this.width = width;
        this.board = new Cell[width][height];
        initBoard();
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    private void initBoard() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++)
                this.board[i][j] = new Cell(new Coordinates(i, j));
        }
    }

    public Cell getCell(Coordinates coordinates) {
        return board[coordinates.getX()][coordinates.getY()];
    }

    @Override
    public String toString() {
        return String.format("GameBoard[board=%s, height=%d, width=%d]", Arrays.deepToString(board), height, width);
    }
}