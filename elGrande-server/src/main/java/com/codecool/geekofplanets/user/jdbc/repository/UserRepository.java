package com.codecool.geekofplanets.user.jdbc.repository;

import com.codecool.geekofplanets.user.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User getUserByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User getUserById(String id);

    @Modifying
    @Query("UPDATE User u SET u.enabled=2")
    void takeAwayPermissions();

    @Modifying
    @Query("UPDATE User u SET u.enabled=1")
    void givePermissions();

    @Modifying
    @Query("UPDATE User u SET u.password = ?1")
    void changePassword(String password);
}
