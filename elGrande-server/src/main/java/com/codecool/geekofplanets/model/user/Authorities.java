package com.codecool.geekofplanets.model.user;

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
public class Authorities {
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    @OneToOne(cascade=CascadeType.MERGE, orphanRemoval=true)
    @JoinColumn(name="username", referencedColumnName="username")
    private User user;

    @Column(name="authority")
    private String authority;

    @Autowired
    public Authorities() {
    }

    public Authorities(User user) {
        this.user = user;
    }
}
