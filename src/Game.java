import java.util.Scanner;

public class Game {
    public String playerName;
    private Scanner sc;

    public Game() {
        this.sc = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to the Magic House!");
        System.out.println("What is your characters name? ");
        playerName = sc.nextLine();
        System.out.println("Hello " + playerName + "! Welcome to the game! ");
            
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

    public void selectClass() {
        String[] classes = {"Warrior", "Rogue"};
        System.out.println("Select your class:");
        for (int i = 0; i < classes.length; i++) {
            System.out.println(i+1 + ". " + classes[i]);
        }

        int classSelection = sc.nextInt();
        System.out.println("Your class is " + classes[classSelection - 1]);
        sc.nextLine();
    }
}
