
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in); 
    
    while (true){
        showInnAlternatives();
        int userInputChoiceInMenu = scan.nextInt(); 
        System.out.println("Du valde alternativ nummer: " + userInputChoiceInMenu);

        if (userInputChoiceInMenu == 1){
            goOnAdventure();
            break; //Avslutar loopen om ett giltigt val görs.
        }
        else if (userInputChoiceInMenu ==2){
            viewCharacterSheet();
            break; //Avslutar loopen om ett giltigt val görs.
        }
        else if (userInputChoiceInMenu == 3){
             restCharacter();
             break; //Avslutar loopen om ett giltigt val görs.
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
