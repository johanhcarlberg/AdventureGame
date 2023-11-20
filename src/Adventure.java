import java.util.Random;

enum EncounterType {
    BATTLE,
    DILEMMA
}

public class Adventure {
    private World world;
    private Random random;
    private Player player;
    private final static int DILEMMA_CHANCE_PERCENTAGE = 0;

    public Adventure(World world, Player player) {
        this.world = world;
        this.player = player;
        this.random = new Random();
    }

    public Encounter getEncounter() {
        EncounterType encounterType = selectEncounterType();
        switch (encounterType) {
            case BATTLE:
                Enemy enemy = getRandomEnemyFromWorld();
                return new Combat(player, enemy);
                // TODO: Create combat instance
            case DILEMMA:
                String dilemma = getRandomDilemmaFromWorld();
                // TODO: Change from type String to type Dilemma once World has changed
                // TODO: Create dilemma instance
                return null;
            default:
                return null;
        }
    }

    private Enemy getRandomEnemyFromWorld() {
        if(world.getEnemies().size() == 0) {
            return null;
        }
        EnemyTypes enemyType = world.getEnemies().get(random.nextInt(world.getEnemies().size()));
        Enemy enemy = enemyType.create(player.getLevel());
        return enemy;
    }

    private String getRandomDilemmaFromWorld() {
        if(world.getDilemmas().size() == 0) {
            return null;
        }
        String dilemma = world.getDilemmas().get(random.nextInt(world.getDilemmas().size()));
        return dilemma;
    }

    private EncounterType selectEncounterType() {
        int randNum = random.nextInt(100) + 1;
        if (randNum <= DILEMMA_CHANCE_PERCENTAGE) {
            return EncounterType.DILEMMA;
        } else {
            return EncounterType.BATTLE;
        }
    }
}
