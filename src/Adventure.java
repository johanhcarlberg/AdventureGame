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

    public void startAdventure() {
        EncounterType encounterType = selectEncounterType();
        switch (encounterType) {
            case BATTLE:
                Enemy enemy = getRandomEnemyFromWorld();
                // TODO: Create combat instance
                break;
            case DILEMMA:
                String dilemma = getRandomDilemmaFromWorld();
                // TODO: Change from type String to type Dilemma once World has changed
                // TODO: Create dilemma instance
                break;
        }
    }

    private Enemy getRandomEnemyFromWorld() {
        Enemy enemy = world.getEnemies().get(random.nextInt(world.getEnemies().size()));
        return enemy;
    }

    private String getRandomDilemmaFromWorld() {
        String dilemma = world.getDilemmas().get(random.nextInt(world.getDilemmas().size()));
        return dilemma;
    }

    private EncounterType selectEncounterType() {
        int randNum = random.nextInt(100) + 1;
        if (randNum <= DILEMMA_CHANCE_PERCENTAGE) {
            // Adventure type is dilemma
            return EncounterType.DILEMMA;
        } else {
            // Adventure type is battle
            return EncounterType.BATTLE;
        }
    }
}
