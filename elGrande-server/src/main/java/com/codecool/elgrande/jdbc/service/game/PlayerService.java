package com.codecool.elgrande.jdbc.service.game;

import com.codecool.elgrande.model.game.actors.Player;

import java.util.List;

public interface PlayerService {

    List<Player> findAllPlayers();
    Player getPlayerById(int id);
    void deletePlayerById(int id);
    void addNewPlayer(Player player);
    long getPlayerCount();
}
