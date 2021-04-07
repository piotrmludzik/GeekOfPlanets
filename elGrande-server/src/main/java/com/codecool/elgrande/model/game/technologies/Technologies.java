package com.codecool.elgrande.model.game.technologies;

import com.codecool.elgrande.model.game.actors.Player;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="technologies")
public class Technologies {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private transient ColonizationTechology colonizationTechology;
    private transient CombatTechnology combatTechnology;
    private transient ConstructionTechnology constructionTechnology;
    private transient DriveTechnology driveTechnology;
    private transient EnergeticTechnology energeticTechnology;
    private transient MiningTechnology miningTechnology;
    private transient SpyTechnology spyTechnology;
    private transient StorageTechnology storageTechnology;

    @ManyToOne
    @JoinColumn(name="technology_id", nullable=false)
    private Player player;

    public Technologies() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
