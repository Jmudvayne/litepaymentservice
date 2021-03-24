/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.payment.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * The model that represents a credit card data in incoming transaction
 *
 *  @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardRequest {

    /**
     * The credit card number
     */
    @NotNull
    @Size(min = 15, max = 19 , message = "{validation.card.size}")
    @Pattern(regexp = "\\d*", message = "{validation.card}")
    private String number;

    /**
     * The credit card cvv2
     */
    @NotNull
    @Pattern(regexp = "\\d{3}", message = "{validation.cvv2}")
    private String cvv2;

    /**
     * The credit card expiration date
     */
    @NotNull
    @Pattern(regexp = "\\d{2}\\-\\d{2}", message = "{validation.expiration_date}")
    private String expirationDate;

    /**
     * The credit card franchise
     */
    @NotNull
    private String franchise;

    @Override
    public String toString(){
        return "CreditCardRequest(number=" + number.substring(0,4) + "******" + number.substring(number.length()-4) +
                ",franchise=" + franchise + ")";
    }
}
