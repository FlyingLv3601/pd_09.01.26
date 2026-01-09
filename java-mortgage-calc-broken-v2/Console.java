import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public static float readInputs(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextFloat();
    }

    public static float readInput(String prompt, float lowLimit, float HighLimit, String someText) {

        Scanner scanner = new Scanner(System.in);
        String errorMessage = "wrong number";
        float input;
        while (true) {
            System.out.print(prompt);

            try {
                input = scanner.nextFloat();

                if (input <= HighLimit && input >= lowLimit)
                    break;

                System.out.print(errorMessage);
            } catch (InputMismatchException e) {
                System.out.println("Nederīga ievade. Lūdzu, ievadiet skaitli.");
                scanner.next(); // Consume the invalid input
            }
        }

        return input;

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String prompt = "enter your number:> ";
        readInputs(prompt);
        readInput(prompt, 1, 10000, "text");
    }
}