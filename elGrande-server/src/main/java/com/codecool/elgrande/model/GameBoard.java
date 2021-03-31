package com.codecool.elgrande.model;

import com.codecool.elgrande.qualifier.BoardHeight;
import com.codecool.elgrande.qualifier.BoardWidth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GameBoard {
    private List<SpaceObject> spaceObjects = new ArrayList<>();
    private List<Planet> planets = new ArrayList<>();
    private Field[][] board;
    private final int height;
    private final int width;


    @Autowired
    public GameBoard(@BoardHeight int height, @BoardWidth int width) {
        this.height = height;
        this.width = width;
        this.board = new Field[width][height];
        createPlanet(new Field(3,1), "Ziemia");
        createPlanet(new Field(17,10), "Mars");
        initBoard();
    }

    public void addSpaceObject(SpaceObject spaceObject){
        spaceObjects.add(spaceObject);
    }


    public Field[][] getBoard() {
        return board;
    }

    public Planet getEmptyPlanet(){
        for (Planet planet: planets){
            if (!planet.getColonized()) {
                planet.Colonize();
                return planet;
            }
        }
        return null;
    }

    public void setBoard(Field[][] board) {
        this.board = board;
    }

    private void initBoard() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++)
                this.board[i][j] = new Field(i, j);
        }
    }

    public Field getCell(Field field) {
        return board[field.getX()][field.getY()];
    }

    public void createPlanet(Field position, String name){
        Planet newPlanet = new Planet(position, name);
        planets.add(newPlanet);
        spaceObjects.add(newPlanet);
    }

    @Override
    public String toString() {
        return String.format("GameBoard[board=%s, height=%d, width=%d]", Arrays.deepToString(board), height, width);
    }
}