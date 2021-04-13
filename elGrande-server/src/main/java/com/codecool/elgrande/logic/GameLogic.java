package com.codecool.elgrande.logic;

import com.codecool.elgrande.jdbc.service.game.PlayerService;
import com.codecool.elgrande.jdbc.service.user.AuthoritiesService;
import com.codecool.elgrande.jdbc.service.user.UserService;
import com.codecool.elgrande.model.game.Field;
import com.codecool.elgrande.model.game.GameBoard;
import com.codecool.elgrande.model.game.actors.Player;
import com.codecool.elgrande.model.game.objects.Planet;
import com.codecool.elgrande.model.user.Authorities;
import com.codecool.elgrande.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class GameLogic {
    private final GameBoard gameBoard;
    private final List<Player> players = new LinkedList<>();
    private final PlayerService playerService;
    private final UserService userService;
    private final AuthoritiesService authoritiesService;

    @Autowired
    public GameLogic(GameBoard gameBoard, PlayerService playerService, UserService userService, AuthoritiesService authoritiesService) {
        this.gameBoard = gameBoard;
        this.playerService = playerService;
        this.userService = userService;
        this.authoritiesService = authoritiesService;
    }

    public Player createPlayer(String name, Field field) {
        Planet planet = gameBoard.getEmptyPlanet();
        Player player = new Player(planet);
        player.setName(name);
        player.setField(field);
        players.add(player);
        addPlayer(player);
        return player;
    }

    public void createUser(User user) {
        addUserToDb(user);
    }

    private void addPlayer(Player player) {
        playerService.addNewPlayer(player);
        gameBoard.addFieldEntity(player);
    }

    private void addUserToDb(User user) {
        userService.addNewUser(user);
        Authorities authorities = new Authorities(user);
        authoritiesService.addNewAuthority(authorities);
    }

    public void getAllUsers() {
        for (User user: userService.findAllUsers()) {
            System.out.println("id: " + user.getId());
            System.out.println("username: " + user.getUsername());
            System.out.println("password: " + user.getPassword());
        }
    }

    public Player getPlayer(int id) {
        return playerService.getPlayerById(id);
    }

    public void movePlayer(int id, Direction direction) {
        Player player = this.getPlayer(id);
        Field actualField = player.getField();
        Field destinationCoordinates = new Field(actualField.getX()+direction.getCoordinates().getX(), actualField.getY()+direction.getCoordinates().getY());
        player.setCoordinates(destinationCoordinates);
        actualField.clearCell();
    }
}
