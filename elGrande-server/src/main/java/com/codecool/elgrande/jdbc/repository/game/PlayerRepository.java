package com.codecool.elgrande.jdbc.repository.game;

import com.codecool.elgrande.model.game.actors.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
