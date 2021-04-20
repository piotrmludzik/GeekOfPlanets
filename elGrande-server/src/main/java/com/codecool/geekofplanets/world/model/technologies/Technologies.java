package com.codecool.geekofplanets.world.model.technologies;

import com.codecool.geekofplanets.world.model.Resources;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Technologies {
    private ColonizationTechology colonizationTechology;
    private CombatTechnology combatTechnology;
    private ConstructionTechnology constructionTechnology;
    private DriveTechnology driveTechnology;
    private EnergeticTechnology energeticTechnology;
    private MiningTechnology miningTechnology;
    private SpyTechnology spyTechnology;
    private StorageTechnology storageTechnology;

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





