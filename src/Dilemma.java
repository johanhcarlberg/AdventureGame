
import java.util.*;
public class Dilemma implements Encounter{

    private Player player;

    private String description;
    private String descriptionSameForEveryDilemma;
    private ArrayList<Answer> listOfChoices; //Variabel för att hålla en lista av typen Answers.

    //Konstruktor för att skapa dilemman. Konstruktor tar emot en String description och en arrayList av answer. Den kan alltså ta emot obegränsat antal choices.
    public Dilemma(String description, ArrayList<Answer> choices, Player player) {
        this.description = description;
        descriptionSameForEveryDilemma = "Du befinner dig i ett knivigt dilemma och måste ta 1 av " + choices.size() + " val. Var extra noga med att mata in rätt alternativ. Det kan komma att straffa sig om du inte är noggrann...";
        this.listOfChoices = choices;
        this.player = player;
    }

    @Override
    public void startEncounter() {
        showDilemma();
    }

    // Presentera dilemmat för spelaren
    public void showDilemma() {
        System.out.println(description);
        System.out.println(descriptionSameForEveryDilemma);
        // Använd den inbyggda funktionen som arraylist ärver från collections och shuffla listan av val.
        Collections.shuffle(listOfChoices);

        //Denna loop presenterar den shufflade listan genom att ta index på aktuell choice + 1 tillsammans med den tillhörande texten.
        for (int i=0; i < listOfChoices.size(); i++) {

            Answer tillfalligAnswer = listOfChoices.get(i); // Hämtar Answer på vald index och lägger den till tillfalligAnswer
            String tillfalligString = tillfalligAnswer.getText(); 
            

            System.out.println((i + 1) + ". " + tillfalligString); //Presenterar texten som sparats i tillfalligString tillsammans med index+1
        }
        System.out.println("");
    }


    //Metoden tar emot användarinput(choice).
    public void resolveDilemma(int choice) {
        
    
            //Kontrollerar först om choice är en giltig siffra - alltså mellan 1 och choices längd. Är den inte det kommer sista else att köras 
            if(choice <= listOfChoices.size()) {

                if(listOfChoices.get(choice -1).isCorrect()) { //minus 1 eftersom vi då får rätt index i listan.

                    System.out.println("Good choice! You survive and, as a reward, receive an experience point.");
                    System.out.println("");
                    System.out.println("-------------------------");
                    player.addExperience(1);

                } else {
                    System.out.println("Your choice is wrong, and as a consequence, you lose one health point.");
                    System.out.println("");
                    System.out.println("-------------------------");
                    player.takeDmg(2);
                }
            
            
            } else {
                System.out.println("You have selected an incorrect option, and as a penalty for your carelessness, you will lose one health point.");
                System.out.println("");
                System.out.println("-------------------------");
                 player.takeDmg(1);
            }
        
    }

    
}