/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.dataprovider.bank;

import com.newstartup.litepaymentservice.application.core.domain.ProcessResponse;
import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.provider.BankProvider;
import reactor.core.publisher.Mono;

public class BankProviderImpl implements BankProvider {
    @Override
    public Mono<ProcessResponse> processTransaction(ProcessTransaction processTransaction) {
        return Mono.just(ProcessResponse
                .builder()
                .withCode("00")
                .withId(processTransaction.getId())
                .withMessage("Transaccíon procesada")
                .build());
    }
}
