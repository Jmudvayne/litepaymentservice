/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.dataprovider.antifraud;

import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.ValidationResponse;
import com.newstartup.litepaymentservice.application.core.domain.provider.AntiFraudProvider;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dao.AntiFraudDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * An implementation of {@link AntiFraudProvider} that needs a {@link AntiFraudDao}
 * in order to make the anti fraud validation
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Slf4j
@RequiredArgsConstructor
public class AntiFraudProviderImpl implements AntiFraudProvider {

    // -----------------------------------------------------------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Message to be used for logging purposes when the validation process starts
     */
    private static final String GETTING_MSG = "Starting validation process for transaction with id: '{}'";

    /**
     * Message to be used for logging purposes when the validation process finishes
     */
    private static final String RETRIEVED_MSG = "Validation complete for transaction with id: '{}' with result: [{}]";

    /**
     * The name of the provider method
     */
    private static final String ROUTE_METHOD = "Route Service - Find Agreements";

    /**
     * Message to be used when it is not possible to retrieve payment agreements
     */
    public static final String ERROR_MSG = "Unable to make validation process for transaction with id [{}], " +
            "an empty Validation Response is gonna be returned ";

    /**
     * The data access object used to have access to the anti fraud service
     */
    private final AntiFraudDao dao;

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Mono<ValidationResponse> validateTransaction(ProcessTransaction processTransaction) {

        log.info(GETTING_MSG, processTransaction.getId());

        return dao.validate(processTransaction)
                .doOnSuccess(validationResponse -> log.info(RETRIEVED_MSG,
                        processTransaction.getId(),
                        validationResponse.getValidationMessage()))
                .onErrorResume(throwable -> {
                    log.error(ERROR_MSG, processTransaction.getId(), throwable);
                    return Mono.just(new ValidationResponse());
                });
    }


}
