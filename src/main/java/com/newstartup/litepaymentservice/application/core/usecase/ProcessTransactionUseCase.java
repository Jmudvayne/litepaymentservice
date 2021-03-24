/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.core.usecase;

import com.newstartup.litepaymentservice.application.core.domain.ProcessResponse;
import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.provider.AntiFraudProvider;
import com.newstartup.litepaymentservice.application.core.domain.provider.BankProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Slf4j
@AllArgsConstructor
public class ProcessTransactionUseCase {

    private final BankProvider bankProvider;
    private final AntiFraudProvider antiFraudProvider;

    private static ProcessResponse apply(Mono<ProcessResponse> processResponseMono) {
        return processResponseMono.block();
    }

    public Mono<ProcessResponse> processTransaction(ProcessTransaction transaction){
        log.info("In processTransaction use case");

        return antiFraudProvider.validateTransaction(transaction)
                .map(validationResponse -> Optional
                        .ofNullable(validationResponse.getTransaction())
                        .map(bankProvider::processTransaction)
                        .orElse(Mono.just(new ProcessResponse("KO", validationResponse.getValidationMessage(), transaction.getId()))))
                .map(ProcessTransactionUseCase::apply);
 }
}
