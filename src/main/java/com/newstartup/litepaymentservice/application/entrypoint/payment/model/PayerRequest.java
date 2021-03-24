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

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * The model that represents a payer data in incoming transaction
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayerRequest {

    /**
     * The payer full name
     */
    @NotNull
    private String fullName;

    /**
     * The payer dni number
     */
    @NotNull
    private String dniNumber;

    /**
     * The payer email address
     */
    @NotNull
    @Email
    private String emailAddress;

    /**
     * The payer contact phone number
     */
    @NotNull
    private String contactPhone;
}
