package com.codecool.geekofplanets.user.jdbc.repository;

import com.codecool.geekofplanets.user.jdbc.model.UserModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    @Query("SELECT u FROM UserModel u WHERE u.username = ?1")
    UserModel getUserByUsername(String username);

    @Query("SELECT u FROM UserModel u WHERE u.id = ?1")
    UserModel getUserById(String id);

    @Modifying
    @Query("UPDATE UserModel u SET u.enabled=2")
    void takeAwayPermissions();

    @Modifying
    @Query("UPDATE UserModel u SET u.enabled=1")
    void givePermissions();

    @Modifying
    @Query("UPDATE UserModel u SET u.password = ?1")
    void changePassword(String password);
}
