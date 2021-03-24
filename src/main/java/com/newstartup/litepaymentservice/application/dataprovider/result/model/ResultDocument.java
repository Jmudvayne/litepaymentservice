package com.newstartup.litepaymentservice.application.dataprovider.result.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "results")
public class ResultDocument {
    @Id
    private String transactionId;

    private LocalDateTime executionDate;

    private String responseCode;

    private String responseMessage;

    private String payerEmail;

    private String payerDni;

    private String transactionType;

    private String cardNumber;

    private String cardIssuerBank;
}
