package com.codecool.elgrande.model.game.technologies;

import com.codecool.elgrande.model.game.actors.Player;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@Setter
@Entity
@Table(name="technologies")
public class Technologies {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="technology_id", nullable=false)
    private Player player;

    public Technologies() {
    }
}
