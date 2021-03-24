/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.dataprovider.bank;

import com.newstartup.litepaymentservice.application.core.domain.ProcessResponse;
import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.provider.BankProvider;

public class BankProviderImpl implements BankProvider {
    @Override
    public ProcessResponse processTransaction(ProcessTransaction processTransaction) {
        return ProcessResponse
                .builder()
                .withCode("00")
                .withId(processTransaction.getCorrelationId())//To Do
                .withMessage("Transaccíon procesada")
                .build();
    }
}
