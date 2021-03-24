/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.payment;

import com.newstartup.litepaymentservice.application.core.usecase.ProcessTransactionUseCase;
import com.newstartup.litepaymentservice.application.entrypoint.payment.mapper.TransactionMapper;
import com.newstartup.litepaymentservice.application.entrypoint.payment.model.TransactionRequest;
import com.newstartup.litepaymentservice.application.entrypoint.payment.model.TransactionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * An implementation of {@link PaymentProcessEntryPoint} that exposes the payment operation
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/payment", produces = "application/json")
public class PaymentProcessController implements PaymentProcessEntryPoint {

    // -----------------------------------------------------------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------------------------------------------------------

    private final ProcessTransactionUseCase processTransactionUseCase;

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    @PostMapping
    public ResponseEntity<TransactionResponse> paymentProcess(
            @RequestHeader Map<String, String> headers,
            @RequestBody TransactionRequest requestBody) {

        var processResponse = processTransactionUseCase
                .processTransaction(TransactionMapper.map(requestBody));

        return ResponseEntity.ok(TransactionMapper.map(processResponse));


    }
}
