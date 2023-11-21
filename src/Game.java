import java.util.Scanner;
import java.util.ArrayList;

enum GameState {
    CREATE_CHARACTER,
    INN,
    ADVENTURE,
}

public class Game {
    public String playerName;
    private Scanner sc;
    private Player player;
    private GameState currentGameState; // Styr vilken del av spelet spelaren är i.
    private Adventure currentAdventure;
    private World currentWorld;

    public Game() {
        this.sc = new Scanner(System.in);
    }

    public void startGame() {
        setupGame();
        System.out.println("Welcome to the Magic House!");
        currentGameState = GameState.CREATE_CHARACTER; 

        //  Huvudloop för spelet. Kollar vilken del av spelet spelaren är i just nu och styr spelet efter det.
        while(true) {
            switch(currentGameState) {
                case CREATE_CHARACTER:
                    createCharacter();
                    currentGameState = GameState.INN;
                    break;
                case INN:
                    showMenuAlternativesLoop();
                    break;
                case ADVENTURE:
                    Encounter encounter = currentAdventure.getEncounter();
                    encounter.startEncounter();
                    currentGameState = GameState.INN;
                    break;
            }
        }
    }

    private void createCharacter() {
        System.out.println("What is your characters name? ");
        playerName = Input.getString();

        CharacterClass playerClass = selectClass();

        player = new Player(playerName, playerClass);

        System.out.println("Hello " + player.getName() + " the " + player.getPlayerClass().getName() + "! Welcome to the game! ");
    }

    public void setupGame() {
        CharacterClass.availableClasses.add(new CharacterClass("Warrior", 5, 3, 2, 2));
        CharacterClass.availableClasses.add(new CharacterClass("Rogue", 3, 2, 5, 3));

        World.availableWorlds.add(new World("Water"));
        World.availableWorlds.add(new World("Volcano"));
        World wateWorld = World.availableWorlds.get(0);
        World volcanWorld = World.availableWorlds.get(1);
        
        EnemyTypes seaHorseType = new EnemyTypes("Seahorse", 10, 3, 4, 7);
        EnemyTypes sharkType = new EnemyTypes("Shark", 15, 5, 5, 10);
        EnemyTypes anemoneType = new EnemyTypes("Anemone", 2, 2, 1, 3);
        EnemyTypes jellyfishType = new EnemyTypes("Jellyfish", 10, 4, 3, 7);
        EnemyTypes starfishType = new EnemyTypes("Starfish", 8, 2, 3, 5);
        
        EnemyTypes fireElementalType = new EnemyTypes("Fire Elemental", 10, 4, 3, 7);
        EnemyTypes lavaSnailType = new EnemyTypes("Lava Snail", 4, 4, 1, 5);
        EnemyTypes salamanderType = new EnemyTypes("Salamander", 10, 3, 4, 7);
        EnemyTypes stoneGiantType = new EnemyTypes("Stone Giant", 12, 5, 3, 8);
        EnemyTypes dragonType = new EnemyTypes("Dragon", 15, 5, 5, 10);

        wateWorld.getEnemies().add(seaHorseType);
        wateWorld.getEnemies().add(sharkType);
        wateWorld.getEnemies().add(anemoneType);
        wateWorld.getEnemies().add(jellyfishType);
        wateWorld.getEnemies().add(starfishType);

        volcanWorld.getEnemies().add(fireElementalType);
        volcanWorld.getEnemies().add(lavaSnailType);
        volcanWorld.getEnemies().add(salamanderType);
        volcanWorld.getEnemies().add(stoneGiantType);
        volcanWorld.getEnemies().add(dragonType);
        // Skapa alla fiendetyper
        // Skapa alla världar
        // Lägg till fienderna i rätt värld
        
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
         wateWorld.getDilemmas().add(new Dilemma("You are walking along a narrow path when a high pitched sound wave cuts through the air. " +
         "The ground starts to vibrate beneath your feet and startled birds fly up from the trees. " +
         "Suddenly, a cascade of rocks and dirt crashes down the slope and you realize you are " +
         "in the middle of a terrible landslide.", dil1Choices));
         wateWorld.getDilemmas().add(new Dilemma("You are walking along a narrow path when a high pitched sound wave cuts through the air. " +
         "The ground starts to vibrate beneath your feet and startled birds fly up from the trees. " + // är det menat att vara tvålikadana? 
         "Suddenly, a cascade of rocks and dirt crashes down the slope and you realize you are " +
         " in the middle of a terrible landslide.", dil1Choices));
         wateWorld.getDilemmas().add(new Dilemma("You see a coin on the ground", dil2Choices));

         //Lägger till två dilemman till volcanWorld
         volcanWorld.getDilemmas().add(new Dilemma("You meet a mysterious man who asks you the way to heaven. What do you answer? ", dil3Choices));
         volcanWorld.getDilemmas().add(new Dilemma("Suddenly you see a bird flying straight towards you. What do you do? ", dil4Choices));
      
        currentWorld = wateWorld; // Spelaren börjar i vattenvärlden.

    }
    
        
    //Metod som visar VärdshusMenyn.
    public void showMenuAlternativesLoop(){
           
         while (true){ //Loopen körs tills ett break kommer.
            showInnAlternatives();
            int userInputChoiceInMenu = Input.getIntegerInRange(1, 3);
            System.out.println("You selected alternative number: " + userInputChoiceInMenu);

            if (userInputChoiceInMenu == 1){
                goOnAdventure();
                break; //Avslutar loopen om ett giltigt val görs.
            }
            else if (userInputChoiceInMenu ==2){
                viewCharacterSheet();
                break; 
            }
            else if (userInputChoiceInMenu == 3){
                restCharacter(player);
                break; 
            }
            else {
                System.out.println("You have entered an incorrect option. Try again. ");
                    
            }

                
        }
    }
    
       

    public void showInnAlternatives() {
        System.out.println("You are now in the inn. Enter the number of your choice:");
        System.out.println("1: Go on an adventure.");
        System.out.println("2: Show your character sheet");
        System.out.println("3: Rest and regain your health");
    }

    public void goOnAdventure() {
        //Gå på äventyr
        currentAdventure = new Adventure(currentWorld, player);
        currentGameState = GameState.ADVENTURE;
    }
    
    public void viewCharacterSheet() {
        System.out.println(player.getName() + " the " + player.getPlayerClass().getName());
        System.out.println("---------------------------------------");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Experience: "+player.getExperience()+"/"+player.getNextLevelExperience());
        System.out.println("Health: " + player.getCurrentHealth() + "/" + player.getMaxHealth());
        System.out.println("Strength: " + player.getStrength());
        System.out.println("Dexterity: " + player.getDexterity());
    }
    
    public void restCharacter(Player player) {
        player.restoreHealth();
        System.out.println("You are now healthier than ever!");
        System.out.println(" ");
        
    }

    public void goIntoDilemma(){
        //Nu har jag tappat bort mig och vet inte när denna ska användas.
        
    }
    public CharacterClass selectClass() {
        CharacterClass[] characterClasses = new CharacterClass[CharacterClass.availableClasses.size()];
        CharacterClass.availableClasses.toArray(characterClasses);

        System.out.println("Select your class:");
        for (int i = 0; i < characterClasses.length; i++) {
            System.out.println(i + 1 + ". " + characterClasses[i].getName());
        }

        int classSelection = Input.getIntegerInRange(1, characterClasses.length);
        CharacterClass selectedClass = characterClasses[classSelection - 1];

        return selectedClass;
    }

    public World getWorld(){
        return currentWorld;
    }

    public static void exitGame() {
        System.out.println("Exiting game..");
        System.exit(0);
    }

}


