/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.payment.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * Model that contains the definition of the request body that will be used
 * for the {@link com.newstartup.litepaymentservice.application.entrypoint.payment.PaymentProcessEntryPoint}
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
@Validated
@AllArgsConstructor
public class TransactionRequest {

    /**
     * The transaction identifier
     */
    @NotNull(message = "{validation.id}")
    private String id;

    /**
     * The credit card data
     */
    @NotNull(message = "{validation.credit_card}")
    @Valid
    private CreditCardRequest creditCard;

    /**
     * The payer date
     */
    @NotNull(message = "{validation.payer}")
    @Valid
    private PayerRequest payer;

    /**
     * The transaction value
     */
    @NotNull(message = "{validation.value_null}")
    @Min(value = 100,message = "{validation.value_min}")
    private BigDecimal value;

    /**
     * The transaction installments
     */
    private Integer installments;

    /**
     * The transaction type
     */
    @NotNull
    @Pattern(regexp = "REFUND|PURCHASE", message = "Invalid operation")
    private String transactionType;

    /**
     * The correlation id used for refund transactions
     */
    private String correlationId;
}
