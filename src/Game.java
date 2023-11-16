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

        String playerClass = selectClass();
        System.out.println(playerClass);

        player = new Player(playerName, playerClass);

        System.out.println("Hello " + player.getName() + " the " + player.getPlayerClass() + "! Welcome to the game! ");
    }

    public void setupGame() {
        CharacterClass.availableClasses.add(new CharacterClass("Warrior", 5, 3, 2, 2));
        CharacterClass.availableClasses.add(new CharacterClass("Rogue", 3, 2, 5, 3));

        World waterWorld = new World("Water");
        EnemyTypes seaHorseType = new EnemyTypes("Seahorse", 10, 3, 4, 7);
        waterWorld.getEnemies().add(seaHorseType.create(2));
        // Skapa alla fiendetyper
        // Skapa alla världar
        // Lägg till fienderna i rätt värld
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
        World world = new World("Volcano");
        currentAdventure = new Adventure(new World("Volcano"));
        currentGameState = GameState.ADVENTURE;
    }
    
    public void viewCharacterSheet() {
        //Visa karaktärs egenskaper
    }
    
    public void restCharacter() {
        //Vila upp karaktären
    }

    //Denna metod bör göras om så att den istället tar emot ett dilemma och kör showDilemma och resolveDilemma på det valda dilemmat. Var ska dilemma skapas? I Värld 1-klassen?
    public void goIntoDilemma(){

        //Skapar en arraylist med dilemma1-val som tar emot typen Answers.
        //Detta görs för att denna lista sedan ska skickas med när man skapar själva dilemmat.
        //ArrayList<Answer> dil1Choices = new ArrayList<Answer>();

        //Skapar och lägger till new Answer till dil1choices-listan.
        //dil1Choices.add(new Answer("Gömma dig under en tunna till höger", true));
        //dil1Choices.add(new Answer("Spring bakåt och ducka", false));
        //dil1Choices.add(new Answer("Spring mot skogen och hoppas på det bästa", false));

        //När första dilemmat skapas skickar man med dilemmats beskrivning och listan på dilemma1-val.
        //Dilemma dilemma1 = new Dilemma("Du vandrar längs en smal stig när en dånande ljudvåg skär genom luften. Marken börjar vibrera under dina fötter och fåglarna flyger panikslagna upp från träden. Plötsligt brakar en kaskad av stenar och jord nedför sluttningen, och du inser att du befinner dig mitt i ett fruktansvärt jordskred.", dil1Choices, player);
       // Dilemma dilemma2 = new Dilemma("Du ser ett mynt som ligger på marken. Vad gör du?", "Plockar upp och granskar myntet", "Låter det ligga. Sånt kan va farligt.");

        //dilemma1.showDilemma();
        //dilemma1.resolveDilemma(sc.nextInt());

       // dilemma2.showDilemma();
        //dilemma2.resolveDilemma(sc.nextInt());
    }
    public String selectClass() {
        String[] classes = { "Warrior", "Rogue" };
        System.out.println("Select your class:");
        for (int i = 0; i < classes.length; i++) {
            System.out.println(i + 1 + ". " + classes[i]);
        }

        int classSelection = sc.nextInt();
        String selectedClass = classes[classSelection - 1];
        System.out.println("Your class is " + selectedClass);
        sc.nextLine();

        return selectedClass;
    }
}
