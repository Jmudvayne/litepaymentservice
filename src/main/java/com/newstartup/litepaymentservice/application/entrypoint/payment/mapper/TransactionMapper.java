/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.payment.mapper;

import com.newstartup.litepaymentservice.application.core.domain.ProcessResponse;
import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.TransactionType;
import com.newstartup.litepaymentservice.application.entrypoint.payment.model.TransactionRequest;
import com.newstartup.litepaymentservice.application.entrypoint.payment.model.TransactionResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * Utility made with the goal to perform conversions between {@link TransactionRequest}, {@link ProcessTransaction}
 * and {@link TransactionResponse}
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Slf4j
public class TransactionMapper {

    // -----------------------------------------------------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Private constructor made for prevent mapper instantiation
     */
    private TransactionMapper(){
        //empty constructor
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Receives an {@link TransactionRequest} and returns its equivalent {@link ProcessTransaction}
     * @param request   an {@link TransactionRequest} instance
     * @return  an {@link ProcessTransaction} instance
     */
    public static ProcessTransaction map(final TransactionRequest request){
        log.info("Mapping transaction request for: [{}]", request);

        var transaction = ProcessTransaction.builder()
                .withId(request.getId())
                .withTransactionType(TransactionType.valueOf(request.getTransactionType()))
                .withCorrelationId(request.getCorrelationId())
                .withInstallments(request.getInstallments() == null ? 0 : request.getInstallments())
                .withCard(CardMapper.map(request.getCreditCard()))
                .withPayer(PayerMapper.map(request.getPayer()))
                .withValue(request.getValue().doubleValue())
                .build();

        log.info("Transaction succesfully mapped: {}", transaction.toString());
        return transaction;
    }

    /**
     * Receives an {@link ProcessResponse} and returns its equivalent {@link TransactionResponse}
     * @param processResponse   an {@link ProcessResponse} instance
     * @return  an {@link TransactionResponse} instance
     */
    public static TransactionResponse map(final ProcessResponse processResponse){
        return TransactionResponse
                .builder()
                .withResponseCode(processResponse.getCode())
                .withTransactionId(processResponse.getId())
                .withResponseMessage(processResponse.getMessage())
                .build();
    }
}
