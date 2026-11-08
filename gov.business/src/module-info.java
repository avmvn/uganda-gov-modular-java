module gov.business {
    requires gov.common;
    requires gov.nationalid;
    requires gov.tax;

    provides gov.common.api.GovernmentService
        with gov.business.service.BusinessRegistrationService;
}
