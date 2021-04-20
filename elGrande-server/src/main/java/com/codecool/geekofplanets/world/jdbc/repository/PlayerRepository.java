package com.codecool.geekofplanets.world.jdbc.repository;

import com.codecool.geekofplanets.world.jdbc.model.PlayerModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerModel, Integer> {

    @Query("SELECT p FROM PlayerModel p WHERE p.id = ?1")
    PlayerModel getPlayerById(String id);

    @Query("SELECT p FROM PlayerModel p WHERE p.userId = ?1")
    PlayerModel getPlayerByUserId(UUID userId);

    @Modifying
    @Query("UPDATE PlayerModel p SET p.name = ?1")
    void changePlayerName(String newName);
}
