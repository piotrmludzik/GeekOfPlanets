package com.codecool.geekofplanets.jdbc.service.game;

import com.codecool.elgrande.model.game.actors.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerService {

    List<Player> findAllPlayers();
    Player getPlayerById(String id);
    Player getPlayerByUserId(UUID userId);
    void deletePlayerById(int id);
    void addNewPlayer(Player player);
    long getPlayerCount();
    void changePlayerName(String newName);
}
