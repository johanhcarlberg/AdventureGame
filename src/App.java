
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in); 
    
    while (true){ //Loopen körs tills ett break kommer.
        showInnAlternatives();
        int userInputChoiceInMenu = scan.nextInt(); 
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
    scan.close();
       
    }

    public static void showInnAlternatives() {
        System.out.println("Du är nu i värdshuset. Ange siffran som hör till ditt val.");
        System.out.println("1: Gå på äventyr");
        System.out.println("2: Granska dina egenskaper");
        System.out.println("3: Vila och återställ din hälsa");
    }

    public static void goOnAdventure() {
        //Gå på äventyr
    }
    
    public static void viewCharacterSheet() {
        //Visa karaktärs egenskaper
    }
    
    public static void restCharacter() {
        //Vila upp karaktären
    }
}
