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
        playerName = sc.nextLine();

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

        wateWorld.getEnemies().add(seaHorseType.create(1));
        wateWorld.getEnemies().add(sharkType.create(1));
        wateWorld.getEnemies().add(anemoneType.create(1));
        wateWorld.getEnemies().add(jellyfishType.create(1));
        wateWorld.getEnemies().add(starfishType.create(1));

        volcanWorld.getEnemies().add(fireElementalType.create(1));
        volcanWorld.getEnemies().add(lavaSnailType.create(1));
        volcanWorld.getEnemies().add(salamanderType.create(1));
        volcanWorld.getEnemies().add(stoneGiantType.create(1));
        volcanWorld.getEnemies().add(dragonType.create(1));
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
        dil1Choices.add(new Answer("Gömma dig under en tunna till höger", true));
        dil1Choices.add(new Answer("Spring bakåt och ducka", false));
        dil1Choices.add(new Answer("Spring mot skogen och hoppas på det bästa", false));

        //Skapar och lägger till new Answer till dil2choices-listan.
        dil2Choices.add(new Answer("Tar myntet och stoppar det i fickan. Yay pengar!", true));
        dil2Choices.add(new Answer("Låter det vara. Mynt är smutsiga", false));
        
        //Skapar och lägger till new Answer till dil3choices-listan.
        dil3Choices.add(new Answer("Du drar ditt svärd och spetsar mannen. Du tänker att nu är han i himlen och bör vara nöjd.", true));
        dil3Choices.add(new Answer("Med en klapp på axeln hänvisar du honom till närmsta langare", false));
        dil3Choices.add(new Answer("Du ignorerar den mystiska mannen och går vidare.", false));

        //Skapar och lägger till new Answer till dil4choices-listan.
        dil4Choices.add(new Answer("Ducka undan fågelns attack. Ta snabbt upp lite frön ur fickan och strö ut över marken", true));
        dil4Choices.add(new Answer("Fäkta med armarna och skrik i hopp om att avvärja fågels attack", false));
        dil4Choices.add(new Answer("Stålsätt dig och invänta krock med fågeln.", false));

        //En arraylist som tar emot Dilemma-objekt skapas och adds dilemmas. När dilemman skapas skickar man med dilemmats beskrivning och listan på dilemma-val.
         ArrayList<Dilemma> dilemmas = new ArrayList<Dilemma>();
         dilemmas.add(new Dilemma("Du vandrar längs en smal stig när en dånande ljudvåg skär genom luften. Marken börjar vibrera under dina fötter och fåglarna flyger panikslagna upp från träden. Plötsligt brakar en kaskad av stenar och jord nedför sluttningen, och du inser att du befinner dig mitt i ett fruktansvärt jordskred.", dil1Choices, player));
         dilemmas.add(new Dilemma("Du ser ett mynt som ligger på marken.", dil2Choices, player));
         dilemmas.add(new Dilemma("Du möter en mystisk man som frågar dig efter vägen till himlen. Vad svarar du?", dil3Choices, player));
         dilemmas.add(new Dilemma("Plötsligt får du syn på en fågel som flyger rakt mot dig.", dil4Choices, player));
      
        currentWorld = wateWorld; // Spelaren börjar i vattenvärlden.
    }
    
        
    //Metod som visar VärdshusMenyn.
    public void showMenuAlternativesLoop(){
           
         while (true){ //Loopen körs tills ett break kommer.
            showInnAlternatives();
            int userInputChoiceInMenu = sc.nextInt(); 
            System.out.println("Du valde alternativ nummer: " + userInputChoiceInMenu);

            if (userInputChoiceInMenu == 1){
                goOnAdventure();
                break; //Avslutar loopen om ett giltigt val görs.
            }
            else if (userInputChoiceInMenu ==2){
                viewCharacterSheet();
                break; 
            }
            else if (userInputChoiceInMenu == 3){
                restCharacter();
                break; 
            }
            else {
                System.out.println("Du har angivit ett felaktiskt alternativ. Försök igen.");
                    
            }

                
        }
    }
    
       

    public void showInnAlternatives() {
        System.out.println("Du är nu i värdshuset. Ange siffran som hör till ditt val.");
        System.out.println("1: Gå på äventyr");
        System.out.println("2: Granska dina egenskaper");
        System.out.println("3: Vila och återställ din hälsa");
    }

    public void goOnAdventure() {
        //Gå på äventyr
        currentAdventure = new Adventure(currentWorld, player);
        currentGameState = GameState.ADVENTURE;
    }
    
    public void viewCharacterSheet() {
        //Visa karaktärs egenskaper
    }
    
    public void restCharacter() {
        //Vila upp karaktären
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

        int classSelection = sc.nextInt();
        CharacterClass selectedClass = characterClasses[classSelection - 1];
        sc.nextLine();

        return selectedClass;
    }

    public static void exitGame() {
        System.out.println("Exiting game..");
        System.exit(0);
    }
    
}
