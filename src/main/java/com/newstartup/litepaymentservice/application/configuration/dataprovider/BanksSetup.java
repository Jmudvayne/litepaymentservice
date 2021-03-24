/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.configuration.dataprovider;

import com.newstartup.litepaymentservice.application.core.domain.provider.BankProvider;
import com.newstartup.litepaymentservice.application.dataprovider.bank.BankProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BanksSetup {

    @Bean
    public BankProvider bankProvider(){
        return  new BankProviderImpl();
    }
}
