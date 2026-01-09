import java.util.Scanner;

public class Main {

    public static double MonthPay(int years, byte MONTH_IN_YEAR, float yearlyPercentageRate, byte PERCENT,
        int totalCreditSum) {
        int months = years * MONTH_IN_YEAR;
        float monthlyRate = yearlyPercentageRate / PERCENT / MONTH_IN_YEAR;
        double futureValueInterestFactor = Math.pow((1 + monthlyRate), months);
        double monthlyMortgagePayment = totalCreditSum * (monthlyRate * futureValueInterestFactor)
                / (futureValueInterestFactor - 1);
        double roundedMonthlyMortgagePayment = (double) Math.round(monthlyMortgagePayment * 100d) / 100d;
        return roundedMonthlyMortgagePayment;
    }

    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        int totalCreditSum = -1;
        float yearlyPercentageRate = -1;
        int years = -1;

        var scanner = new Scanner(System.in);

        System.out.print("|===> Hipotekārā kredīta kalkulators <===|\n");

        while (true) {
            System.out.print("Ievadiet kredīta summu: ");
            totalCreditSum = scanner.nextInt();

            if (totalCreditSum >= 1_000 && totalCreditSum <= 1_000_000)
                break;

            System.out.print("Kredīta summai jābūt robežās no 1'000 līdz 1'000'000\n");
        }

        while (true) {
            System.out.print("Ievadiet gada procentu likmi: ");
            yearlyPercentageRate = scanner.nextFloat();

            if (yearlyPercentageRate > 0 && yearlyPercentageRate <= 30)
                break;

            System.out.print("Procentu likmei jābūt robežās no 0 līdz 30\n");
        }

        while (true) {
            System.out.print("Ievadiet periodu gados: ");
            years = scanner.nextInt();

            if (years >= 1 && years <= 30)
                break;

            System.out.print("Periodam jābūt robežās no 1 līdz 30\n");
        }

        // https://www.luminor.lv/lv/privatpersonam/hipotekara-kredita-kalkulators

        System.out.println("Ikmēneša maksājums: "
                + MonthPay(years, MONTH_IN_YEAR, yearlyPercentageRate, PERCENT, totalCreditSum) + " EUR");
        scanner.close();
    }
}