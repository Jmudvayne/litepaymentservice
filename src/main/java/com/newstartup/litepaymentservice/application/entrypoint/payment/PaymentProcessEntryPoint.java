/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */
package com.newstartup.litepaymentservice.application.entrypoint.payment;

import com.newstartup.litepaymentservice.application.entrypoint.payment.model.TransactionRequest;
import com.newstartup.litepaymentservice.application.entrypoint.payment.model.TransactionResponse;
import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Map;

/**
 * An interface that defines the contract that a Payment Process controller should fulfill
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Api(produces = "application/json")
public interface PaymentProcessEntryPoint {
    /**
     * Validates and returns a {@link TransactionResponse} with the process result
     * the {@link ProcessTransaction} processing
     *
     * @param requestBody an {@link ProcessTransaction} instance
     * @return a {@link ResponseEntity} with a {@link TransactionResponse} into its body
     */
    @ApiOperation("Process a transaction request")
    Mono<ResponseEntity<TransactionResponse>> paymentProcess(
            Map<String, String> headers,
            @ApiParam(
                    value = "The transaction that is going to be processed",
                    required = true
            ) @Valid TransactionRequest requestBody);
}
