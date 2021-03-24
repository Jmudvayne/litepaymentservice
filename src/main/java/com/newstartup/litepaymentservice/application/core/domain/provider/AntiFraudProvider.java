/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 */

package com.newstartup.litepaymentservice.application.core.domain.provider;

import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.ValidationResponse;

/**
 * The provider that manage the validate operation around {@link ProcessTransaction}
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@FunctionalInterface
public interface AntiFraudProvider {

    /**
     * Validate the transaction to process
     * @param processTransaction the transaction to process
     * @return a {@link ValidationResponse}
     */
    ValidationResponse validateTransaction (ProcessTransaction processTransaction);
}
