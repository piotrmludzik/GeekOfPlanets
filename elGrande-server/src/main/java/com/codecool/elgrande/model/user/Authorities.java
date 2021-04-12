package com.codecool.elgrande.model.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@Setter
@Entity
@Table(name="authorities")
public class Authorities {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade=CascadeType.MERGE, orphanRemoval=true)
    @JoinColumn(name="username", referencedColumnName="username")
    private User user;

    @Autowired
    public Authorities() {
    }

    public Authorities(User user) {
        this.user = user;
    }
}
