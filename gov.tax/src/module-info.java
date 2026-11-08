module gov.tax {
    requires gov.common;

    exports gov.tax.api to gov.business;

    provides gov.common.api.GovernmentService
        with gov.tax.service.TaxService;
}
