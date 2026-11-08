module gov.nationalid {
    requires gov.common;

    exports gov.nationalid.verify to gov.passport, gov.business;

    provides gov.common.api.GovernmentService
        with gov.nationalid.service.NationalIdService;
}
