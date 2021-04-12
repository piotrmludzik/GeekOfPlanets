package com.codecool.elgrande.model.game.technologies;

import com.codecool.elgrande.model.game.Resources;

public class Technologies {
    private final ColonizationTechology colonizationTechology = new ColonizationTechology();
    private final CombatTechnology combatTechnology = new CombatTechnology();
    private final ConstructionTechnology constructionTechnology = new ConstructionTechnology();
    private final DriveTechnology driveTechnology = new DriveTechnology();
    private final EnergeticTechnology energeticTechnology = new EnergeticTechnology();
    private final MiningTechnology miningTechnology = new MiningTechnology();
    private final SpyTechnology spyTechnology = new SpyTechnology();
    private final StorageTechnology storageTechnology = new StorageTechnology();

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




