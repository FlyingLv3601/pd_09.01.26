import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.print("|===> Hipotekārā kredīta kalkulators <===|\n");

            float totalCreditSum = Console.readInput("Ievadiet kredīta summu: ", 1000, 10000000,
                    "Kredīta summai jābūt robežās no 1'000 līdz 1'000'000\n");

            float yearlyPercentageRate = Console.readInput("Ievadiet gada procentu likmi: ", 0, 30,
                    "Procentu likmei jābūt robežās no 0 līdz 30\n");

            float years = Console.readInput("Ievadiet periodu gados: ", 1, 30, "Periodam jābūt robežās no 1 līdz 30\n");

            var mortgageCalculator = new MortgageCalculator();
            System.out.println("Ikmēneša maksājums: " + mortgageCalculator.calculate(totalCreditSum, yearlyPercentageRate, years) + " EUR");

            if (Console.readInputs("Vai vēlaties turpināt? Jā[1]/Nē[0]: ") == 0)
                break;
        }

        return mortgageCalculator;
    }
}
