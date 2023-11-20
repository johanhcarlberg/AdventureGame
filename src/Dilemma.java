
import java.util.*;
public class Dilemma implements Encounter{

    private Player player;

    private String description;
    private String descriptionSameForEveryDilemma;
    private ArrayList<Answer> listOfChoices; //Variabel för att hålla en lista av typen Answers.

    //Konstruktor för att skapa dilemman. Konstruktor tar emot en String description och en arrayList av answer. Den kan alltså ta emot obegränsat antal choices.
    public Dilemma(String description, ArrayList<Answer> choices, Player player) {
        this.description = description;
        descriptionSameForEveryDilemma = "Du befinner dig i ett knivigt dilemma och måste ta ett av " + choices.size() + " val. Var extra noga med att mata in rätt alternativ. Det kan komma att straffa sig om du inte är noggrann...";
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

        for (int i=0; i < listOfChoices.size(); i++) {

            Answer tillfalligAnswer = listOfChoices.get(i); // Hämtar Answer på vald index och lägger den till tillfalligAnswer
            String tillfalligString = tillfalligAnswer.getText(); //Hämtar 
            

            System.out.println((i + 1) + ". " + tillfalligString); //Presenterar texten som sparats i tillfalligString tillsammans med index+1
        }
        System.out.println("");
    }


    //Metoden tar emot användarinput(choice).
    public void resolveDilemma(int choice) {
        
    
            //Kontrollerar först om choice är en giltig siffra - alltså mellan 1 och choices längd. Är den inte det kommer  
            if(choice <= listOfChoices.size()) {

                if(listOfChoices.get(choice -1).isCorrect()) {

                    System.out.println("Bra val! Du överlever och får som belöning ett hälsopoäng.");
                    System.out.println("");
                    System.out.println("-------------------------");
                    //player1.increaseHealthScore();

                } else {
                    System.out.println("Ditt val är fel och som en konsekvens tappar du ett hälsopoäng.");
                    System.out.println("");
                    System.out.println("-------------------------");
                    player.takeDmg(2);
                }
            
            
            } else {
                System.out.println("Du har angivit ett felaktiskt alternativ och som straff för din slarvighet kommer du förlora ett hälsopoäng.");
                System.out.println("");
                System.out.println("-------------------------");
                 //Player1.DecreaseHeathScore();
            }
        
    }

    
}