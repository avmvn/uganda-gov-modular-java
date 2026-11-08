package gov.tax.api;

import gov.tax.internal.TaxRecords;

public class TinChecker {

    private final TaxRecords records = new TaxRecords();

    public boolean isValidTin(String tin) {
        return records.exists(tin);
    }

    public String getTaxpayerName(String tin) {
        return records.getTaxpayerName(tin);
    }
}
