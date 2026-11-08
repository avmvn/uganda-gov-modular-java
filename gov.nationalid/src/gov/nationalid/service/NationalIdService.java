package gov.nationalid.service;

import gov.common.api.GovernmentService;
import gov.nationalid.verify.IdVerifier;

public class NationalIdService implements GovernmentService {

    private final IdVerifier verifier = new IdVerifier();

    @Override
    public String getServiceName() {
        return "National ID Management";
    }

    @Override
    public String getDepartment() {
        return "National Identification and Registration Authority";
    }

    @Override
    public void run() {
        checkId("CM90012345ABCD");
        checkId("ZZ00000000FAKE");
    }

    private void checkId(String nin) {
        System.out.println("Checking NIN: " + nin);
        if (verifier.isValid(nin)) {
            System.out.println("  VALID - Citizen: " + verifier.getCitizenName(nin));
        } else {
            System.out.println("  INVALID - NIN not found.");
        }
    }
}
