package gov.tax.internal;

public class TaxCalculator {

    // Simple demo rule (not the real URA law)
    private static final double TAX_FREE_AMOUNT = 235000;
    private static final double RATE = 0.10;

    public double calculateMonthlyTax(double monthlyIncome) {
        if (monthlyIncome <= TAX_FREE_AMOUNT) {
            return 0;
        }
        return (monthlyIncome - TAX_FREE_AMOUNT) * RATE;
    }
}
