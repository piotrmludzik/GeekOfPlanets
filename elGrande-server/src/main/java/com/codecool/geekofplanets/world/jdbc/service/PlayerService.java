package com.codecool.geekofplanets.world.jdbc.service;

import com.codecool.geekofplanets.world.model.actors.Player;

import java.util.List;
import java.util.UUID;

public interface PlayerService {

    List<Player> findAllPlayers();
    Player getPlayerById(String id);
    Player getPlayerByUserId(UUID userId);
    void deletePlayerById(int id);
    void addNewPlayer(Player player, UUID id);
    long getPlayerCount();
    void changePlayerName(String newName);
}
