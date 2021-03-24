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

/**
 * The payer date which requests to process the payment
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Payer {

    /**
     * The payer full names
     */
    private String fullNames;

    /**
     * The payer document number identification
     */
    private String dniNumber;

    /**
     * The payer email
     */
    private String emailAddress;

    /**
     * The payer contact phone
     */
    private String contactPhone;
}
