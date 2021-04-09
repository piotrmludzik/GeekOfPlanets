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
        if (name.equals("colonization")) {
            resources.substractCost(colonizationTechology.getCost());
            this.colonizationTechology.levelUp();
        } else if (name.equals("combat")) {
            resources.substractCost(combatTechnology.getCost());
            this.combatTechnology.levelUp();
        } else if (name.equals("construction")) {
            resources.substractCost(constructionTechnology.getCost());
            this.constructionTechnology.levelUp();
        } else if (name.equals("drive")) {
            resources.substractCost(driveTechnology.getCost());
            this.driveTechnology.levelUp();
        } else if (name.equals("energetic")) {
            resources.substractCost(energeticTechnology.getCost());
            this.energeticTechnology.levelUp();
        } else if (name.equals("mining")) {
            resources.substractCost(miningTechnology.getCost());
            this.miningTechnology.levelUp();
        } else if (name.equals("spy")) {
            resources.substractCost(spyTechnology.getCost());
            this.spyTechnology.levelUp();
        } else if (name.equals("storage")) {
            resources.substractCost(storageTechnology.getCost());
            this.storageTechnology.levelUp();
        }

    }
}




