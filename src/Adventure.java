import java.util.Random;

enum AdventureType {
    BATTLE,
    DILEMMA
}

public class Adventure {
    private World world;
    private Random random;
    private final static int DILEMMA_CHANCE = 15;

    public Adventure(World world) {
        this.world = world;
        this.random = new Random();
    }

    public void selectAdventureType() {
        int randNum = random.nextInt(100) + 1;
        if (randNum <= DILEMMA_CHANCE) {
            // Adventure type is dilemma
            // TODO: Select a dilemma from world
        } else {
            // Adventure type is battle
            // TODO: Select a monster from world
        }
    }
}
