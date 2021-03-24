/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.payment.mapper;

import com.newstartup.litepaymentservice.application.core.domain.CreditCard;
import com.newstartup.litepaymentservice.application.entrypoint.payment.model.CreditCardRequest;

/**
 * Utility made with the goal to perform conversions between {@link CreditCardRequest} and {@link CreditCard}
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
public class CardMapper {

    // -----------------------------------------------------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Private constructor made for prevent mapper instantiation
     */
    private CardMapper(){
        //empty constructor
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Receives an {@link CreditCardRequest} and returns its equivalent {@link CreditCard}
     * @param request   an {@link CreditCardRequest} instance
     * @return  an {@link CreditCard} instance
     */
    public static CreditCard map(CreditCardRequest request){
        return CreditCard
                .builder()
                .withCvv2(request.getCvv2())
                .withExpirationDate(request.getExpirationDate())
                .withFranchise(request.getFranchise())
                .withIssuerBank("XX")
                .withNumber(request.getNumber())
                .build();
    }
}
