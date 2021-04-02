package com.codecool.elgrande.model.user;

import com.codecool.elgrande.model.game.actors.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="user_registration_data")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;

    private transient Player player;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Autowired
    public User() {
    }

    @Column(name="user_id")
    public int getPlayerId() {
        return player.getId();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
