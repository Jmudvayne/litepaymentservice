/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.configuration.usecase;

import com.newstartup.litepaymentservice.application.core.domain.provider.AntiFraudProvider;
import com.newstartup.litepaymentservice.application.core.domain.provider.BankProvider;
import com.newstartup.litepaymentservice.application.core.domain.provider.ResultProvider;
import com.newstartup.litepaymentservice.application.core.usecase.ProcessTransactionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class in charge of the use cases' setup
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Configuration
public class UseCasesSetup {

    @Bean
    public ProcessTransactionUseCase processTransactionUseCase(
            AntiFraudProvider antiFraudProvider,
            BankProvider bankProvider,
            ResultProvider resultProvider){
        return new ProcessTransactionUseCase(
                bankProvider,
                antiFraudProvider,
                resultProvider);
    }
}
