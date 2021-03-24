/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.configuration.dataprovider;

import com.newstartup.litepaymentservice.application.core.domain.provider.AntiFraudProvider;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.AntiFraudProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AntiFraudsSetup {

    @Bean
    public AntiFraudProvider antiFraudProvider(){
        return new AntiFraudProviderImpl();
    }
}
