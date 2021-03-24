/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * The purchase or refund data to be process
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Slf4j
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class ProcessTransaction {

    /**
     * The payer which requests to process the payment
     */
    private Payer payer;

    /**
     * The credit card with which the payment will be processed
     */
    private CreditCard card;

    /**
     * The value of the transaction
     */
    private Double value;

    /**
     * The installments of the purchase transaction
     */
    private Integer installments;

    /**
     * The transaction type
     */
    private TransactionType transactionType;

    /**
     * The purchase transaction related in the refund type transaction
     */
    private String correlationId;
}
