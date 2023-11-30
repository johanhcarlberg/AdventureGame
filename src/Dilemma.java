
//Dilemma-klassen implementerar Encounter.
import java.util.*;
public class Dilemma implements Encounter{

    private Player player;
    private String description;
    private String descriptionSameForEveryDilemma;
    private ArrayList<Answer> listOfChoices;
    private int damageWhenLoosingDilemma = 2;
    private int gainExperiencePoint = 1;

    //Konstruktorn tar emot en beskrivning av dilemmat, en arrayList av answer, och en Spelare.
    public Dilemma(String description, ArrayList<Answer> choices, Player player) {
        this.description = description;
        descriptionSameForEveryDilemma = "You find yourself in a tricky dilemma and must make 1 out of " + choices.size() + " choices. Be extra careful to enter the correct option. It may come back to haunt you if you're not careful...";
        this.listOfChoices = choices;
        this.player = player;
    }
    
    //Alternativ konstruktor som används innan vi har player-objekt. Därav satt till null.
    public Dilemma(String description, ArrayList<Answer> choices) {
        this(description, choices, null);
    }

    //Metod som överskuggar annan metod från överordnad klass (Encounter).
    @Override
    public void startEncounter() {
        showDilemma();
        resolveDilemma(Input.getIntegerInRange(1, listOfChoices.size()));
    }

    // Presentera dilemmat för spelaren
    public void showDilemma() {
        System.out.println(description);
        System.out.println(descriptionSameForEveryDilemma);
        // Använd den inbyggda funktionen som arraylist ärver från collections och shuffla listan av val.
        Collections.shuffle(listOfChoices);

        //Denna loop presenterar den shufflade svarsalternativlistan genom att ta index på aktuell choice tillsammans med den tillhörande texten.
        for (int i=0; i < listOfChoices.size(); i++) {

            Answer currentAnswerChoiceAtSpecificIndex = listOfChoices.get(i); 
            String textOfCurrentAnswerChoice = currentAnswerChoiceAtSpecificIndex.getText(); 

            //Presenterar index + 1 tillsammans med spelarens svarsalternativ.
            System.out.println((i + 1) + ". " + textOfCurrentAnswerChoice); 
        }
        System.out.println("");
    }
    
    //Metod som hanterar spelarens rätta eller fel svar.
    public void resolveDilemma(int choice) {    
        //Kontrollerar om valt svarsalternativ har en boolean som är true. (minus 1 eftersom vi då får rätt index i listan.)
        if(listOfChoices.get(choice -1).isCorrect()) { 

            System.out.println("Good choice! You survive and, as a reward, receive an experience point.");
            System.out.println("");
            System.out.println("-------------------------");
            player.addExperience(gainExperiencePoint);

        } else {
            System.out.println("Your choice is wrong, and as a consequence, you lose " + damageWhenLoosingDilemma + "health point.");
            System.out.println("");
            System.out.println("-------------------------");
            player.takeDamage(damageWhenLoosingDilemma);
            if (player.getCurrentHealth() <= 0) {
                gameOver();
            }
        }
    }

    //Egen game-over metod. Ta bort denna och använda den statiska från Game-klassen istället?
    private void gameOver() {
        System.out.println(player.getName() + " the " + player.getPlayerClass().getName() + " has been defeated.");
        System.out.println("\n\n GAME OVER \n\n");
        Game.exitGame();
    }

    //Här anropas orginalkonstruktorn (när vi har ett player-objekt att skicka med)
    public Dilemma clone(Player player) {
        return new Dilemma(description, listOfChoices, player);
    }

    
}