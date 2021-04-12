package com.codecool.elgrande.model.game.technologies;

import com.codecool.elgrande.model.game.Resources;
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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private transient ColonizationTechology colonizationTechology = new ColonizationTechology();
    private transient CombatTechnology combatTechnology = new CombatTechnology();
    private transient ConstructionTechnology constructionTechnology = new ConstructionTechnology();
    private transient DriveTechnology driveTechnology = new DriveTechnology();
    private transient EnergeticTechnology energeticTechnology = new EnergeticTechnology();
    private transient MiningTechnology miningTechnology = new MiningTechnology();
    private transient SpyTechnology spyTechnology = new SpyTechnology();
    private transient StorageTechnology storageTechnology = new StorageTechnology();


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





