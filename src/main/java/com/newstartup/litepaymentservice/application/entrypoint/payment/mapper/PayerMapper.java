/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.entrypoint.payment.mapper;

import com.newstartup.litepaymentservice.application.core.domain.Payer;
import com.newstartup.litepaymentservice.application.entrypoint.payment.model.PayerRequest;

/**
 * Utility made with the goal to perform conversions between {@link PayerRequest} and {@link Payer}
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
public class PayerMapper {

    // -----------------------------------------------------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Private constructor made for prevent mapper instantiation
     */
    private PayerMapper(){
        //empty constructor
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Receives an {@link PayerRequest} and returns its equivalent {@link Payer}
     * @param request   an {@link PayerRequest} instance
     * @return  an {@link Payer} instance
     */
    public static Payer map(PayerRequest request){
        return Payer
                .builder()
                .withFullNames(request.getFullName())
                .withDniNumber(request.getDniNumber())
                .withContactPhone(request.getContactPhone())
                .withEmailAddress(request.getEmailAddress())
                .build();
    }

}
