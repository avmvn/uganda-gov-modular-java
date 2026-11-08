package gov.nationalid.verify;

import gov.nationalid.internal.CitizenRegistry;

public class IdVerifier {

    private final CitizenRegistry registry = new CitizenRegistry();

    public boolean isValid(String nin) {
        return registry.exists(nin);
    }

    public String getCitizenName(String nin) {
        String name = registry.findName(nin);
        return (name == null) ? "UNKNOWN" : name;
    }
}
