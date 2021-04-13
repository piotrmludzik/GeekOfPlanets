package com.codecool.elgrande.game.jdbc.repository;

import com.codecool.elgrande.game.model.actors.Player;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

    @Modifying
    @Query("UPDATE Player p SET p.name = ?1")
    void changePlayerName(String newName);
}
