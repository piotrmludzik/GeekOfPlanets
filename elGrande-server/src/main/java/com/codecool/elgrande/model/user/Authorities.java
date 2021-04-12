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

    @OneToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="username", referencedColumnName="username")
    private User user;

    @Column(name="authority")
    private String authority;

    @Autowired
    public Authorities() {
    }
}
