/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */
package com.newstartup.litepaymentservice.application.entrypoint.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Model that contains the definition of the response body that will be used
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class TransactionResponse {

    /**
     * The response code
     */
    private String responseCode;

    /**
     * The transaction id
     */
    private String transactionId;

    /**
     * The response message
     */
    private String responseMessage;
}
