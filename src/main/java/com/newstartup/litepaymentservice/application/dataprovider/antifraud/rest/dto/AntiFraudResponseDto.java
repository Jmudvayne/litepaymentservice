package com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The response from the anti fraud service
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AntiFraudResponseDto {

    /**
     * The response code
     */
    private String antiFraudResponseCode;

    /**
     * The response message
     */
    private String antiFraudResponseMessage;
}
