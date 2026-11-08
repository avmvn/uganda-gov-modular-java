package gov.passport.service;

import gov.common.api.GovernmentService;
import gov.nationalid.verify.IdVerifier;
import gov.passport.internal.PassportNumberGenerator;

public class PassportService implements GovernmentService {

    private final IdVerifier idVerifier = new IdVerifier();
    private final PassportNumberGenerator generator = new PassportNumberGenerator();

    @Override
    public String getServiceName() {
        return "Passport Processing";
    }

    @Override
    public String getDepartment() {
        return "Directorate of Citizenship and Immigration Control";
    }

    @Override
    public void run() {
        applyForPassport("CM90012345ABCD");
        applyForPassport("XX00000000FAKE");
    }

    private void applyForPassport(String nin) {
        System.out.println("Passport application with NIN: " + nin);
        if (idVerifier.isValid(nin)) {
            System.out.println("  NIN verified for " + idVerifier.getCitizenName(nin));
            System.out.println("  Passport issued: " + generator.next());
        } else {
            System.out.println("  REJECTED - NIN not found in the National ID system.");
        }
    }
}
