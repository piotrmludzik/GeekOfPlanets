package com.codecool.elgrande.jdbc.service.game;

import com.codecool.elgrande.model.game.actors.Player;
import com.codecool.elgrande.jdbc.repository.game.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Player getPlayerById(int id) {
        Optional<Player> opt = playerRepository.findById(id);
        return opt.orElse(null);
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
}