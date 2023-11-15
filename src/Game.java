import java.util.Scanner;

enum GameState {
    CREATE_CHARACTER,
    INN,
    ADVENTURE,
    BATTLE,
    DILEMMA,
}

public class Game {
    public String playerName;
    private Scanner sc;
    private Player player;
    private GameState currentGameState;

    public Game() {
        this.sc = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to the Magic House!");
        System.out.println("What is your characters name? ");
        playerName = sc.nextLine();

        String playerClass = selectClass();
        System.out.println(playerClass);

        player = new Player(playerName, playerClass);

        System.out.println("Hello " + player.getName() + " the " + player.getPlayerClass() + "! Welcome to the game! ");
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
    }
    
    public void viewCharacterSheet() {
        //Visa karaktärs egenskaper
    }
    
    public void restCharacter() {
        //Vila upp karaktären
    }

    //Denna metod bör göras om så att den istället tar emot ett dilemma och kör showDilemma och resolveDilemma på det valda dilemmat. Var ska dilemma skapas? I Värld 1-klassen?
    public void goIntoDilemma(){
        Dilemma dilemma1 = new Dilemma("Du vandrar längs en smal stig när en dånande ljudvåg skär genom luften. Marken börjar vibrera under dina fötter och fåglarna flyger panikslagna upp från träden. Plötsligt brakar en kaskad av stenar och jord nedför sluttningen, och du inser att du befinner dig mitt i ett fruktansvärt jordskred."
        , "Gömma dig under en tunna till höger", "Spring bakåt och ducka");
        Dilemma dilemma2 = new Dilemma("Du ser ett mynt som ligger på marken. Vad gör du?", "Plockar upp och granskar myntet", "Låter det ligga. Sånt kan va farligt.");

        dilemma1.showDilemma();
        dilemma1.resolveDilemma(sc.nextInt());

        dilemma2.showDilemma();
        dilemma2.resolveDilemma(sc.nextInt());
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
