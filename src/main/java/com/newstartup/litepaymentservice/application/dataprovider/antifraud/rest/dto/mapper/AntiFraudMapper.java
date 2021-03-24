package com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto.mapper;

import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.ValidationResponse;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto.AntiFraudRequestDto;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto.AntiFraudResponseDto;

/**
 * Utility made with the goal to perform conversions between {@link ProcessTransaction} and {@link AntiFraudRequestDto}
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
public class AntiFraudMapper {

    // -----------------------------------------------------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Private constructor made in order to prevent mapper instantiation
     */
    private AntiFraudMapper(){
        // empty constructor
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Receives an {@link ProcessTransaction} in order to parse it to
     * an {@link AntiFraudRequestDto} instance
     *
     * @param processTransaction an {@link ProcessTransaction} instance
     * @return an {@link AntiFraudRequestDto} instance
     */
    public static AntiFraudRequestDto map(ProcessTransaction processTransaction){
            return AntiFraudRequestDto
                    .builder()
                    .withCardNumber(processTransaction.getCard().getNumber())
                    .withPayerDni(processTransaction.getPayer().getDniNumber())
                    .withPayerEmail(processTransaction.getPayer().getEmailAddress())
                    .build();
    }

    /**
     * Receives an {@link AntiFraudResponseDto}  and a  {@link ProcessTransaction in order to parse it to
     * an {@link ValidationResponse} instance
     *
     * @param antiFraudResponseDto  an {@link AntiFraudResponseDto} instance
     * @param processTransaction    a {@link ProcessTransaction} instance
     * @return a {@link ValidationResponse} instance
     */
    public static ValidationResponse mapResponse(AntiFraudResponseDto antiFraudResponseDto,
                                         ProcessTransaction processTransaction){
        return ValidationResponse
                .builder()
                .withValidationMessage(antiFraudResponseDto.getAntiFraudResponseMessage())
                .withTransaction(antiFraudResponseDto
                        .getAntiFraudResponseCode().equals("OK") ? processTransaction: null)
                .build();
    }
}
