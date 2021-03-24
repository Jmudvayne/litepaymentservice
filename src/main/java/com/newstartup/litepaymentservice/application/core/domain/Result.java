package com.newstartup.litepaymentservice.application.core.domain;

import lombok.*;

import java.time.LocalDateTime;

/**
 * A model to be saved into the application data store in order to have tracking
 * around every transaction to arrive
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class Result {

    /**
     * The date in which the transaction was executed
     */
    private LocalDateTime executionDate;

    /**
     * The transaction identifier
     */
    private String transactionId;

    /**
     * The payer of the transaction
     */
    private Payer payer;

    /**
     * The masked card number
     */
    private String carNumber;

    /**
     * The response code of the transaction
     */
    private String responseCode;

    /**
     * The response message of the transaction
     */
    private String responseMessage;

    private String cardIssuerBank;

    /**
     * Takes the data passed as methos arguments in order to generate a {@link Result} instance
     * which is gonna be saved lately into the database
     *
     * @param processTransaction    the transaction to process
     * @param processResponse       the process response
     * @return
     */
    public static Result from(ProcessTransaction processTransaction,
                              ProcessResponse processResponse){

        return Result
                .builder()
                .withCarNumber(processTransaction.getCard().getMaskedNumber())
                .withPayer(processTransaction.getPayer())
                .withExecutionDate(LocalDateTime.now())
                .withResponseCode(processResponse.getCode())
                .withResponseMessage(processResponse.getMessage())
                .withCardIssuerBank(processTransaction.getCard().getIssuerBank())
                .build();
    }

}
