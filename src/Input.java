import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);
    public static String getString() {
        String inputString = sc.nextLine();
        if (inputString.toLowerCase().equals("exit")) {
            Game.exitGame();
        }
        return inputString;
    }

    public static int getInteger() {
        while(true) {
            String inputString = getString();
            try {
                int inputInt = Integer.parseInt(inputString);
                return inputInt;
            } catch(NumberFormatException e) {
                System.out.println("Invalid number, try again.");
            }
        }
    }
}
