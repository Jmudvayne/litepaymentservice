package com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dao;

import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.ValidationResponse;
import reactor.core.publisher.Mono;

/**
 * A {@link ValidationResponse}'s DA0
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@FunctionalInterface
public interface AntiFraudDao {

    /**
     * Returns a {@link Mono<ValidationResponse>} depending of the given parameter
     * @param processTransaction the processTransaction to validate
     * @return a {@link Mono<ValidationResponse>}
     */
    Mono<ValidationResponse> validate(ProcessTransaction processTransaction);
}
