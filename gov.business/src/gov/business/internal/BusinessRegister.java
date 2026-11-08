package gov.business.internal;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class BusinessRegister {

    private final List<String> registeredBusinesses = new ArrayList<>();

    public String register(String businessName) {
        registeredBusinesses.add(businessName);
        return "BR-" + Year.now().getValue() + "-"
                + String.format("%04d", registeredBusinesses.size());
    }
}
