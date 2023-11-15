import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    public String playerName;
     
    Scanner sc = new Scanner(System.in);

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


    //Denna metod bör göras om och flyttas.
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
    
}
