/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.dataprovider.antifraud;

import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.ValidationResponse;
import com.newstartup.litepaymentservice.application.core.domain.provider.AntiFraudProvider;

public class AntiFraudProviderImpl implements AntiFraudProvider {
    @Override
    public ValidationResponse validateTransaction(ProcessTransaction processTransaction) {

        return ValidationResponse
                .builder()
                .withTransaction(processTransaction)
                .withValidationMessage("Valid transaction")
                .build();
    }
}
