/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.core.usecase;

import com.newstartup.litepaymentservice.application.core.domain.ProcessResponse;
import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.Result;
import com.newstartup.litepaymentservice.application.core.domain.provider.AntiFraudProvider;
import com.newstartup.litepaymentservice.application.core.domain.provider.BankProvider;
import com.newstartup.litepaymentservice.application.core.domain.provider.ResultProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * Use case: given an {@link ProcessTransaction}, a  {@link ProcessResponse} must be returned
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Slf4j
@AllArgsConstructor
public class ProcessTransactionUseCase {

    // -----------------------------------------------------------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The service that will allow the banking process
     */
    private final BankProvider bankProvider;

    /**
     * The service that will allow the anti fraud validation
     */
    private final AntiFraudProvider antiFraudProvider;

    /**
     * The service that will allow the execution result management
     */
    private final ResultProvider resultProvider;

    private static final String FAIL_FRAUD_VALIDATION_CODE = "KO";

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The use case execution logic
     *
     * @param transaction
     * @return
     */
    public Mono<ProcessResponse> processTransaction(ProcessTransaction transaction) {

        return antiFraudProvider.validateTransaction(transaction)
                .map(validationResponse -> Optional
                        .ofNullable(validationResponse.getTransaction())
                        .map(bankProvider::processTransaction)
                        .orElse(Mono.just(new ProcessResponse(FAIL_FRAUD_VALIDATION_CODE,
                                validationResponse.getValidationMessage(), transaction.getId()))))
                .doOnSuccess(processResponseMono -> resultProvider.add(Result.from(transaction, processResponseMono.block())))
                .map(ProcessTransactionUseCase::apply);
    }

    /**
     *
     * @param processResponseMono
     * @return
     */
    private static ProcessResponse apply(Mono<ProcessResponse> processResponseMono) {
        return processResponseMono.block();
    }
}
