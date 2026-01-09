public class MortgageCalculator {
    int credit;
    int yearlyPercentageRate;
    int years;

    public final static byte MONTH_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    public MortgageCalculator(int credit, int yearlyPercentageRate, int years) {
        this.credit = credit;
        this.yearlyPercentageRate = yearlyPercentageRate;
        this.years = years;
    }

    private int getMonths() {
        return this.years *= MONTH_IN_YEAR;
    }

    private float getMonthlyRate() {
        return this.yearlyPercentageRate /= PERCENT / MONTH_IN_YEAR;
    }

    private double getFutureValueInterestFactor() {
        return Math.pow((1 + getMonthlyRate()), getMonths());
    }

    // https://www.luminor.lv/lv/privatpersonam/hipotekara-kredita-kalkulators
    public double calculate() {
        double monthlyMortgagePayment = this.credit * (getMonthlyRate() * getFutureValueInterestFactor()) / (getFutureValueInterestFactor() - 1);
        return Math.round(monthlyMortgagePayment * 100d) / 100d; // two digits after the decimal point
    }
}
