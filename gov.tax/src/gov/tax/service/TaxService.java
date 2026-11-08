package gov.tax.service;

import gov.common.api.GovernmentService;
import gov.tax.internal.TaxCalculator;

public class TaxService implements GovernmentService {

    private final TaxCalculator calculator = new TaxCalculator();

    @Override
    public String getServiceName() {
        return "Tax Collection";
    }

    @Override
    public String getDepartment() {
        return "Revenue Authority";
    }

    @Override
    public void run() {
        double income = 1200000;
        double tax = calculator.calculateMonthlyTax(income);
        System.out.println("Monthly income : UGX " + String.format("%,.0f", income));
        System.out.println("Tax to pay     : UGX " + String.format("%,.0f", tax));
    }
}
