package gov.business.service;

import gov.business.internal.BusinessRegister;
import gov.common.api.GovernmentService;
import gov.nationalid.verify.IdVerifier;
import gov.tax.api.TinChecker;

public class BusinessRegistrationService implements GovernmentService {

    private final IdVerifier idVerifier = new IdVerifier();
    private final TinChecker tinChecker = new TinChecker();
    private final BusinessRegister register = new BusinessRegister();

    @Override
    public String getServiceName() {
        return "Business Registration";
    }

    @Override
    public String getDepartment() {
        return "Registration Services Bureau";
    }

    @Override
    public void run() {
        registerBusiness("Nakato Traders Ltd", "CM90012345ABCD", "1000123456");
        registerBusiness("Fake Company Ltd", "CM90012345ABCD", "9999999999");
    }

    private void registerBusiness(String name, String ownerNin, String tin) {
        System.out.println("Registering business: " + name);

        if (!idVerifier.isValid(ownerNin)) {
            System.out.println("  REJECTED - Owner NIN is not valid.");
            return;
        }
        if (!tinChecker.isValidTin(tin)) {
            System.out.println("  REJECTED - TIN " + tin + " is not registered for tax.");
            return;
        }

        System.out.println("  Owner : " + idVerifier.getCitizenName(ownerNin));
        System.out.println("  TIN   : " + tin + " (" + tinChecker.getTaxpayerName(tin) + ")");
        System.out.println("  Registration number: " + register.register(name));
    }
}
