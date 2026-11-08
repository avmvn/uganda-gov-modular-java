package gov.nationalid.internal;

import java.util.HashMap;
import java.util.Map;

public class CitizenRegistry {

    private final Map<String, String> citizens = new HashMap<>();

    public CitizenRegistry() {
        citizens.put("CM90012345ABCD", "Aisha Nakato");
        citizens.put("CF85098765WXYZ", "Brian Okello");
    }

    public boolean exists(String nin) {
        return citizens.containsKey(nin);
    }

    public String findName(String nin) {
        return citizens.get(nin);
    }
}
