package com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The request for the anti fraud service
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class AntiFraudRequestDto {

    /**
     * The card number to validate
     */
    private String cardNumber;

    /**
     * The payer identification to validate
     */
    private String payerDni;

    /**
     * The payer email to validate
     */
    private String payerEmail;


}
