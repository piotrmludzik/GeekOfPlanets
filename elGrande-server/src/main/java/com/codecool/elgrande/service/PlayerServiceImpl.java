package com.codecool.elgrande.service;

import com.codecool.elgrande.model.Player;
import com.codecool.elgrande.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    PlayerRepository repository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Player> findAllPlayers() {
        return (List<Player>) repository.findAll();
    }

    @Override
    public Player getPlayerById(int id) {
        Optional<Player> opt = repository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void deletePlayerById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void addNewPlayer(Player player) {
        repository.save(player);
    }

    @Override
    public long getPlayerCount() {
        return repository.count();
    }
}
