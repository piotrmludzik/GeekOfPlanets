package com.codecool.geekofplanets.jdbc.service.game;

import com.codecool.elgrande.jdbc.repository.game.PlayerRepository;
import com.codecool.elgrande.model.game.actors.Player;
import com.codecool.geekofplanets.jdbc.repository.game.PlayerRepository;
import com.codecool.geekofplanets.model.game.actors.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAllPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(String id) {
        return playerRepository.getPlayerById(id);
    }

    @Override
    public Player getPlayerByUserId(UUID userId) {
        return playerRepository.getPlayerByUserId(userId);
    }

    @Override
    public void deletePlayerById(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void addNewPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public long getPlayerCount() {
        return playerRepository.count();
    }

    @Override
    public void changePlayerName(String newName) {
        playerRepository.changePlayerName(newName);
    }
}
