import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public String playerName;
    private Player player;
    private GameStateManager gameStateManager;
    private Adventure currentAdventure;
    private World currentWorld;
    private Inn inn;

    public void startGame() {
        gameStateManager = new GameStateManager();
        setupGame();
        printInstructions();
        gameStateManager.setCurrentGameState(GameState.CREATE_CHARACTER);

        //  Huvudloop för spelet. Kollar vilken del av spelet spelaren är i just nu och styr spelet efter det.
        while(true) {
            switch(gameStateManager.getCurrentGameState()) {
                case CREATE_CHARACTER:
                    CharacterCreator characterCreator = new CharacterCreator();
                    this.player = characterCreator.createCharacter();
                    inn = createInn();
                    addWorldRequirements();
                    gameStateManager.setCurrentGameState(GameState.INN);
                    break;
                case INN:
                    inn.showMenuAlternatives();
                    break;
                case ADVENTURE:
                    System.out.println("\nYou go on an adventure in the " + currentWorld.getTheme().toLowerCase() + " world..");
                    System.out.println("---------------------------------------");
                    System.out.println(currentWorld.getDescription());
                    System.out.println("---------------------------------------");
                    currentWorld.printRequirements();
                    currentAdventure = new Adventure(currentWorld, player);
                    Encounter encounter = currentAdventure.getEncounter();
                    encounter.startEncounter();
                    checkWorldCompletion();
                    gameStateManager.setCurrentGameState(GameState.INN);
                    break;
            }
        }
    }

    private void loadWorlds() {
        String waterWorldDescription = "As you descend into the crystal-clear waters of Aquatica, a breathtaking world unfolds around you. " + 
        "The surroundings are a mesmerizing blend of vibrant colors, diverse ecosystems, and ancient ruins. " + 
        "The ocean stretches in all directions, and the play of light creates a dynamic and ever-changing landscape.";
        World.availableWorlds.add(new World("Water", waterWorldDescription));
        String volcanoWorldDescription = "All around where you stand are hot springs that shoot out bubbles of lava, you see lava flowing down the mouintain sides. " +
        "Due to the active volcano beneath you there is a haze of sulphur in the air. What lights up your surroundings are the lava flowing along the ground and the mountain. " +
        "You can see a small passage between the lava"; 
        World.availableWorlds.add(new World("Volcano", volcanoWorldDescription));
    }

    private void loadEnemyTypes() {
        World waterWorld = World.availableWorlds.get(0);
        World volcanoWorld = World.availableWorlds.get(1);
        
        EnemyType seaHorseType = new EnemyType("Seahorse", 6, 2, 3, 30);
        EnemyType sharkType = new EnemyType("Shark", 10, 4, 3, 45);
        EnemyType anemoneType = new EnemyType("Anemone", 2, 2, 1, 15);
        EnemyType jellyfishType = new EnemyType("Jellyfish", 6, 3, 2, 30);
        EnemyType starfishType = new EnemyType("Starfish", 5, 2, 3, 25);
        
        EnemyType fireElementalType = new EnemyType("Fire Elemental", 7, 3, 2, 35);
        EnemyType lavaSnailType = new EnemyType("Lava Snail", 4, 2, 1, 20);
        EnemyType salamanderType = new EnemyType("Salamander", 6, 2, 3, 30);
        EnemyType stoneGiantType = new EnemyType("Stone Giant", 8, 4, 2, 45);
        EnemyType dragonType = new EnemyType("Dragon", 10, 3, 4, 50);

        waterWorld.getEnemies().add(seaHorseType);
        waterWorld.getEnemies().add(sharkType);
        waterWorld.getEnemies().add(anemoneType);
        waterWorld.getEnemies().add(jellyfishType);
        waterWorld.getEnemies().add(starfishType);

        volcanoWorld.getEnemies().add(fireElementalType);
        volcanoWorld.getEnemies().add(lavaSnailType);
        volcanoWorld.getEnemies().add(salamanderType);
        volcanoWorld.getEnemies().add(stoneGiantType);
        volcanoWorld.getEnemies().add(dragonType);
    }

    private void loadDilemmas() {
        World waterWorld = World.availableWorlds.get(0);
        World volcanoWorld = World.availableWorlds.get(1);

        //Skapar olika arraylists med dilemma-val som tar emot typen Answers.
        //Detta görs för att denna lista sedan ska skickas med när man skapar själva dilemmat.
        ArrayList<Answer> dil1Choices = new ArrayList<Answer>();
        ArrayList<Answer> dil2Choices = new ArrayList<Answer>();
        ArrayList<Answer> dil3Choices = new ArrayList<Answer>();
        ArrayList<Answer> dil4Choices = new ArrayList<Answer>();

        //Skapar och lägger till new Answer till dil1choices-listan.
        dil1Choices.add(new Answer("Hide behind a barrel to your right", true));
        dil1Choices.add(new Answer("Run backwards and duck", false));
        dil1Choices.add(new Answer("Run towards the forest and hope for the best", false));

        //Skapar och lägger till new Answer till dil2choices-listan.
        dil2Choices.add(new Answer("Take the coin and put it in the pocket. Yay money!", true));
        dil2Choices.add(new Answer("Leave it be, coins are filthy", false));
        
        //Skapar och lägger till new Answer till dil3choices-listan.
        dil3Choices.add(new Answer("You pull out your sword and impale the man. You believe he is in heaven and should be happy now.", true));
        dil3Choices.add(new Answer("With a pat on the shoulder you guide him to the nearest dealer", false));
        dil3Choices.add(new Answer("You ignore the man and walk past him.", false));

        //Skapar och lägger till new Answer till dil4choices-listan.
        dil4Choices.add(new Answer("Dodge the birds attack. Quickly take some seeds out of your pocket and scatter on the ground.", true));
        dil4Choices.add(new Answer("Flail with your arms and scream in hopes it is warding off the birds attack!", false));
        dil4Choices.add(new Answer("Brace yourself and wait for the collision with the bird!.", false));

        //Dilemman läggs till wateWorld. När dilemman skapas skickar man med dilemmats beskrivning och listan på dilemma-val. + spelaren
         waterWorld.getDilemmas().add(new Dilemma("You are walking along a narrow path when a high pitched sound wave cuts through the air. " +
         "The ground starts to vibrate beneath your feet and startled birds fly up from the trees. " +
         "Suddenly, a cascade of rocks and dirt crashes down the slope and you realize you are " +
         "in the middle of a terrible landslide.", dil1Choices));
         waterWorld.getDilemmas().add(new Dilemma("You see a coin on the ground", dil2Choices));

         waterWorld.getDilemmas().add(new Dilemma("You encounter a Nymph of the Lake. She asks you to solve a riddle for her.\n \"I flow without rest, a liquid dance, Quenching thirst with a subtle trance. In rivers wide or drops so small, I'm essential, embraced by all.\"\n \"What am I?\"", 
         new ArrayList<>(Arrays.asList(
            new Answer("Water", true),
            new Answer("Fire", false),
            new Answer("Earth", false)
            ))));

         //Lägger till två dilemman till volcanWorld
         volcanoWorld.getDilemmas().add(new Dilemma("You meet a mysterious man who asks you the way to heaven. What do you answer? ", dil3Choices));
         volcanoWorld.getDilemmas().add(new Dilemma("Suddenly you see a bird flying straight towards you. What do you do? ", dil4Choices));
    }

    private void loadCharacterClasses() {
        CharacterClass.availableClasses.add(new CharacterClass("Warrior", 5, 3, 2, 2));
        CharacterClass.availableClasses.add(new CharacterClass("Rogue", 3, 2, 5, 3));
    }

    public void setupGame() {
        loadCharacterClasses();
        loadWorlds();
        loadEnemyTypes();
        loadDilemmas();        

        World waterWorld = World.availableWorlds.get(0);
        currentWorld = waterWorld; // Spelaren börjar i vattenvärlden.

    }

    private Inn createInn() {
        return new Inn(player, gameStateManager);
    }

    public World getWorld(){
        return currentWorld;
    }

    public static void exitGame() {
        System.out.println("Exiting game..");
        System.exit(0);
    }

    private void addWorldRequirements() {
        World waterWorld = World.availableWorlds.get(0);
        waterWorld.addCompletionRequirement(new LevelRequirement(2, player));
        World volcanoWorld = World.availableWorlds.get(1);
        volcanoWorld.addCompletionRequirement(new LevelRequirement(3, player));
    }

    private void checkWorldCompletion() {
        if (currentWorld.isCompleted()) {
            String worldCompletionText = "Well, well, well. Look at you! You have grown even stronger. You are ready for a new challenge!";
            System.out.println(worldCompletionText);
            int nextWorldIndex = World.availableWorlds.indexOf(currentWorld) + 1;
            if (nextWorldIndex > World.availableWorlds.size() - 1) {
                String gameCompletionText = String.format("Congratulations %s! You have deafeated the strongest monsters of this world and grown into quite the legend among you peers! You are truly one of the greatest adventurers ever!", player.getName());
                System.out.println(gameCompletionText);
                Game.exitGame();
            }
            currentWorld = World.availableWorlds.get(nextWorldIndex);
            String nextWorldText = String.format("You now have access to the %s world.", currentWorld.getTheme().toLowerCase());
            System.out.println(nextWorldText);
        }
    }

    private void printInstructions() {
        System.out.println("In numbered menus, enter the corresponding number for a selection to select that option.");
        System.out.println("To exit the game at any point, write \"exit\"\n");
    }

    public static void gameOver(){ 
        System.out.println("\n-----------------------------------------------------\n");
        System.out.println("The enemy was too strong! This is where your story ends. How sad.");
        System.out.println("\n\n GAME OVER \n\n");
        Game.exitGame();
    }

}


