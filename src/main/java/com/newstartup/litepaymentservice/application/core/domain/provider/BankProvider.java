/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.core.domain.provider;

import com.newstartup.litepaymentservice.application.core.domain.ProcessResponse;
import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;

/**
 * The provider that manage the bank process operation around {@link ProcessTransaction}
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@FunctionalInterface
public interface BankProvider {

    ProcessResponse processTransaction(ProcessTransaction processTransaction);
}
