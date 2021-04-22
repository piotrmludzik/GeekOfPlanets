package com.codecool.geekofplanets.world.universe;


import com.codecool.geekofplanets.game.config.qualifier.BoardHeight;
import com.codecool.geekofplanets.game.config.qualifier.BoardWidth;
import com.codecool.geekofplanets.world.jdbc.service.FieldService;
import com.codecool.geekofplanets.world.universe.actors.Player;
import com.codecool.geekofplanets.world.universe.objects.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GameBoard {
    private final FieldService fieldService;
    private final List<Player> players = new ArrayList<>();
    private final List<Planet> planets = new ArrayList<>();
    private final Field[][] board;
    private final int height;
    private final int width;

    @Autowired
    public GameBoard(FieldService fieldService, @BoardHeight int height, @BoardWidth int width) {
        this.fieldService = fieldService;
        this.height = height;
        this.width = width;
        this.board = new Field[width][height];
        initBoard();
        setPlanetOnBoard(board[3][1], "Earth", new Resources(1000,500,200,0));
        setPlanetOnBoard(board[17][10], "Mars", new Resources(1000,600,300,0));
    }

    private void initBoard() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.board[i][j] = new Field(i, j);
            }
        }
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void setPlanetOnBoard(Field position, String name, Resources resources){
        // TODO: move to GameLogic
        Planet newPlanet = new Planet(position);
        newPlanet.setField(position);
        newPlanet.setResources(resources);
        newPlanet.setName(name);
        planets.add(newPlanet);
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

    @Override
    public String toString() {
        return String.format("GameBoard[board=%s, height=%d, width=%d]", Arrays.deepToString(board), height, width);
    }

    public Field getField(int x, int y){
        return board[x][y];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
