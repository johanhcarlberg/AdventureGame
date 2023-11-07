import java.util.Scanner;

public class Menu {
    public String playerName;

    public void startGame() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome to the Magic House!");
            System.out.println("What is your characters name? ");
            playerName = sc.nextLine();
        }
        System.out.println("Hello " + playerName + "! Welcome to the game! ");
        
    }
}
