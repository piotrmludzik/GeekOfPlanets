package com.codecool.elgrande.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Entity
@Table(name="authorities")
public class Authorities {

    private transient User user;

    @Id
    @Column(name="username")
    private String username;

    @Column(name="authority")
    private String authority;

    @Autowired
    public Authorities() {
    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getAuthority() {
        return authority;
    }
}
