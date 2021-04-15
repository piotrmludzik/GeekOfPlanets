package com.codecool.elgrande.model.game;

import com.codecool.elgrande.configuration.qualifier.BoardHeight;
import com.codecool.elgrande.configuration.qualifier.BoardWidth;
import com.codecool.elgrande.model.game.objects.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GameBoard {
    private final List<FieldEntity> fieldEntities = new ArrayList<>();
    private final List<Planet> planets = new ArrayList<>();
    private final Field[][] board;
    private final int height;
    private final int width;

    @Autowired
    public GameBoard(@BoardHeight int height, @BoardWidth int width) {
        this.height = height;
        this.width = width;
        this.board = new Field[width][height];
        setPlanetOnBoard(new Field(3,1), "Earth");
        setPlanetOnBoard(new Field(17,10), "Mars");
        initBoard();
    }

    public void addFieldEntity(FieldEntity fieldEntity){
        fieldEntities.add(fieldEntity);
    }

    public void setPlanetOnBoard(Field position, String name){
        // TODO: move to GameLogic
        Planet newPlanet = new Planet(position);
        newPlanet.setName(name);
        planets.add(newPlanet);
        fieldEntities.add(newPlanet);
    }

    public Planet getEmptyPlanet(){
        // TODO: to separate class taking care of computations
        for (Planet planet: planets){
            if (!planet.isColonized()) {
                planet.colonize();
                return planet;
            }
        }
        return null;
    }

    private void initBoard() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++)
                this.board[i][j] = new Field(i, j);
        }
    }

    @Override
    public String toString() {
        return String.format("GameBoard[board=%s, height=%d, width=%d]", Arrays.deepToString(board), height, width);
    }
}
