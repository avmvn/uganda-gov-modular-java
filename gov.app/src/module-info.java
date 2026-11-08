module gov.app {
    requires gov.common;
    requires gov.nationalid;
    requires gov.tax;
    requires gov.passport;
    requires gov.business;

    uses gov.common.api.GovernmentService;
}
