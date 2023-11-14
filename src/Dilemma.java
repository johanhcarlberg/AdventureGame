
//Klassen bör istället använda sig av collections(trorjag) för att kunna använda en shuffle-metod för att presentera spelarens svarsalternativ för att inte alltid få det rätta svaret på första platsen.
public class Dilemma {

    private String description;
    private String descriptionSameForEveryDilemma;
    private String choice1;
    private String choice2;

    //Konstruktor för att skapa dilemman.
    public Dilemma(String description, String choice1, String choice2) {
        this.description = description;
        descriptionSameForEveryDilemma = "Du befinner dig i ett knivigt dilemma och måste ta ett av två val. Var extra noga med att mata in rätt alternativ. Det kan komma att straffa sig om du inte är noggrann...";
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    // Presentera dilemmat för spelaren
    public void showDilemma() {
        System.out.println(description);
        System.out.println(descriptionSameForEveryDilemma);
        System.out.println("1. " + choice1);
        System.out.println("2. " + choice2);
        System.out.println("");
    }


    //Denna metod bör på sikt hamna i en loop för att hantera felaktig inmatning, istället för att ge straffpoäng för fel inmatning.
    public void resolveDilemma(int choice) {

            if (choice == 1) {
                System.out.println("Bra val! Du överlever och får som belöning ett hälsopoäng.");
                System.out.println("");
                System.out.println("-------------------------");
                //player1.increaseHealthScore();
                
            } else if (choice == 2) {
                System.out.println("Ditt val är fel och som en konsekvens tappar du ett hälsopoäng.");
                System.out.println("");
                System.out.println("-------------------------");
                //Player1.DecreaseHeathScore();
                
            } else {
                System.out.println("Du har angivit ett felaktiskt alternativ. Du straffas därför och förlorar hälsopoäng");
                System.out.println("");
                System.out.println("-------------------------");
                //Player1.DecreaseHeathScore();
            }
        
    }

    
}
