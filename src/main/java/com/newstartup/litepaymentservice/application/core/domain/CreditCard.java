/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.core.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * The credit card data with which
 * the payment will be processed
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
public class CreditCard {

    /**
     * The card number
     */
    private String number;

    /**
     * The card security code
     */
    private String cvv2;

    /**
     * The card expiration date
     */
    private String expirationDate;

    /**
     * The card issuer bank
     */
    private String issuerBank;

    /**
     * The card franchise
     */
    private String franchise;


}
