package com.newstartup.litepaymentservice.application.dataprovider.result.model.mapper;

import com.newstartup.litepaymentservice.application.core.domain.Result;
import com.newstartup.litepaymentservice.application.dataprovider.result.model.ResultDocument;

/**
 * Utility made with the goal to perform conversions between {@link Result} and {@link ResultDocument}
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
public class ResultDocumentMapper {

    // -----------------------------------------------------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Private constructor made in order to prevent the mapper instantiation
     */
    private ResultDocumentMapper() {
        // empty constructor
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Receives a {@link Result} instance and returns its representation
     * as a {@link ResultDocument} instance
     *
     * @param result a {@link Result} instance
     * @return a {@link ResultDocument} instance
     */
    public static ResultDocument map(Result result) {

        return ResultDocument
                .builder()
                .executionDate(result.getExecutionDate())
                .cardIssuerBank(result.getCardIssuerBank())
                .cardNumber(result.getCarNumber())
                .payerDni(result.getPayer().getDniNumber())
                .payerEmail(result.getPayer().getEmailAddress())
                .transactionId(result.getTransactionId())
                .responseCode(result.getResponseCode())
                .responseMessage(result.getResponseMessage())
                .build();
    }
}
