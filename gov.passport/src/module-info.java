module gov.passport {
    requires gov.common;
    requires gov.nationalid;

    provides gov.common.api.GovernmentService
        with gov.passport.service.PassportService;
}
