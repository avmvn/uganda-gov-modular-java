package gov.app;

import gov.common.api.GovernmentService;

import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== UGANDA GOVERNMENT DIGITAL SYSTEM =====");

        // PART 1: Show the modules that are running
        System.out.println("\nPART 1: Modules loaded");
        ModuleLayer.boot().modules().stream()
                .map(Module::getName)
                .filter(name -> name.startsWith("gov."))
                .sorted()
                .forEach(name -> System.out.println("  - " + name));

        // PART 2: Run every service using ServiceLoader
        System.out.println("\nPART 2: Running the services");
        ServiceLoader<GovernmentService> services =
                ServiceLoader.load(GovernmentService.class);

        int count = 0;
        for (GovernmentService service : services) {
            count++;
            System.out.println("\n--- Service " + count + ": " + service.getServiceName() + " ---");
            System.out.println("Department: " + service.getDepartment());
            System.out.println("Module    : " + service.getClass().getModule().getName());
            service.run();
        }
        System.out.println("\nTotal services loaded: " + count);

        // PART 3: Show which module can access which package
        System.out.println("\nPART 3: Access control between modules");
        checkAccess("gov.app", "gov.common", "gov.common.api");
        checkAccess("gov.business", "gov.tax", "gov.tax.api");
        checkAccess("gov.passport", "gov.tax", "gov.tax.api");
        checkAccess("gov.app", "gov.tax", "gov.tax.api");
        checkAccess("gov.app", "gov.tax", "gov.tax.internal");
        checkAccess("gov.passport", "gov.nationalid", "gov.nationalid.verify");
        checkAccess("gov.business", "gov.nationalid", "gov.nationalid.verify");
        checkAccess("gov.app", "gov.nationalid", "gov.nationalid.verify");
        checkAccess("gov.app", "gov.nationalid", "gov.nationalid.internal");

        // PART 4: Benefits of modularization
        System.out.println("\nPART 4: Why modularization helps");
        System.out.println("  SECURITY        : Internal packages are hidden. Only approved modules can use shared packages.");
        System.out.println("  MAINTAINABILITY : Each department changes its own module without breaking the others.");
        System.out.println("  SCALABILITY     : A new service (example: land registry) is added as a new module.");
    }

    private static void checkAccess(String fromModule, String targetModule, String packageName) {
        Module from = ModuleLayer.boot().findModule(fromModule).orElseThrow();
        Module target = ModuleLayer.boot().findModule(targetModule).orElseThrow();
        boolean allowed = target.isExported(packageName, from);
        System.out.println("  " + fromModule + " -> " + packageName
                + " : " + (allowed ? "ALLOWED" : "BLOCKED"));
    }
}
