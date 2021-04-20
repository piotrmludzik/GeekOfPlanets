package com.codecool.geekofplanets.user.jdbc.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.UUID;

@Component
@Getter
@Setter
@Entity
@Table(name="authorities")
public class AuthoritiesModel {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToOne(cascade= CascadeType.MERGE, orphanRemoval=true)
    @JoinColumn(name="username", referencedColumnName="username")
    private UserModel user;

    @Column(name="authority")
    private String authority;

    @Autowired
    public AuthoritiesModel() {
    }

    public AuthoritiesModel(UserModel user) {
        this.user = user;
    }
}
