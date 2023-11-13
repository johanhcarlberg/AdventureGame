import java.util.Random;

enum EncounterType {
    BATTLE,
    DILEMMA
}

public class Adventure {
    private World world;
    private Random random;
    private final static int DILEMMA_CHANCE_PERCENTAGE = 15;

    public Adventure(World world) {
        this.world = world;
        this.random = new Random();
    }

    public World getWorld() {
        return world;
    }

    public void startAdventure() {
        EncounterType encounterType = selectEncounterType();
        switch (encounterType) {
            case BATTLE:
                // TODO: Select an enemy from world and start battle
                break;
            case DILEMMA:
                // TODO: Select a dilemma from world and start dilemma
                break;
        }
    }

    private EncounterType selectEncounterType() {
        int randNum = random.nextInt(100) + 1;
        if (randNum <= DILEMMA_CHANCE) {
            // Adventure type is dilemma
            return EncounterType.DILEMMA;
        } else {
            // Adventure type is battle
            return EncounterType.BATTLE;
        }
    }
}
