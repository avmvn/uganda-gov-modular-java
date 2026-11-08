package gov.tax.internal;

import java.util.HashMap;
import java.util.Map;

public class TaxRecords {

    private final Map<String, String> taxpayers = new HashMap<>();

    public TaxRecords() {
        taxpayers.put("1000123456", "Nakato Traders Ltd");
        taxpayers.put("1000654321", "Okello and Sons Ltd");
    }

    public boolean exists(String tin) {
        return taxpayers.containsKey(tin);
    }

    public String getTaxpayerName(String tin) {
        return taxpayers.getOrDefault(tin, "UNKNOWN");
    }
}
