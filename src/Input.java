import java.util.InputMismatchException;
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

    public static int getIntegerInRange(int lower, int upper) {
        while(true) {
            try {
                int inputInt = getInteger();
                if (inputInt < lower || inputInt > upper) {
                    throw new InputMismatchException();
                }
                return inputInt;
            } catch(InputMismatchException e) {
                System.out.println("Number is not between " + lower + " and " + upper + ". Try again.");
            }
        }
    }
}
