package com.codecool.elgrande.service;

import com.codecool.elgrande.model.Player;

import java.util.List;

public interface PlayerService {

    List<Player> findAllPlayers();
    Player getPlayerById(int id);
    void deletePlayerById(int id);
    void addNewPlayer(Player player);
    long getPlayerCount();
}
