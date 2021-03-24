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

import java.util.Optional;

@Slf4j
@AllArgsConstructor
public class ProcessTransactionUseCase {

    private final BankProvider bankProvider;
    private final AntiFraudProvider antiFraudProvider;


    public ProcessResponse processTransaction(ProcessTransaction transaction){
        log.info("In processTransaction use case");
       return Optional.ofNullable(antiFraudProvider.validateTransaction(transaction))
               .map(validationResponseMono -> bankProvider.processTransaction(transaction))
               .orElse(null);
    }
}
