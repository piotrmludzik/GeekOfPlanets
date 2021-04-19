package com.codecool.geekofplanets.model.game.technologies;

import com.codecool.elgrande.model.game.Resources;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Component
@Getter
@Setter
@Entity
@Table(name="technologies")
public class Technologies {
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="org.hibernate.id.UUIDGenerator")
    private UUID id;

    private transient ColonizationTechology colonizationTechology;
    private transient CombatTechnology combatTechnology;
    private transient ConstructionTechnology constructionTechnology;
    private transient DriveTechnology driveTechnology;
    private transient EnergeticTechnology energeticTechnology;
    private transient MiningTechnology miningTechnology;
    private transient SpyTechnology spyTechnology;
    private transient StorageTechnology storageTechnology;


    public Technologies() {
    }

    public void discover(String name, Resources resources) {
        switch (name) {
            case "colonization":
                resources.substractCost(colonizationTechology.getCost());
                this.colonizationTechology.levelUp();
                break;
            case "combat":
                resources.substractCost(combatTechnology.getCost());
                this.combatTechnology.levelUp();
                break;
            case "construction":
                resources.substractCost(constructionTechnology.getCost());
                this.constructionTechnology.levelUp();
                break;
            case "drive":
                resources.substractCost(driveTechnology.getCost());
                this.driveTechnology.levelUp();
                break;
            case "energetic":
                resources.substractCost(energeticTechnology.getCost());
                this.energeticTechnology.levelUp();
                break;
            case "mining":
                resources.substractCost(miningTechnology.getCost());
                this.miningTechnology.levelUp();
                break;
            case "spy":
                resources.substractCost(spyTechnology.getCost());
                this.spyTechnology.levelUp();
                break;
            case "storage":
                resources.substractCost(storageTechnology.getCost());
                this.storageTechnology.levelUp();
        }
    }
}





