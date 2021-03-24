/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.configuration.dataprovider;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.newstartup.litepaymentservice.application.core.domain.provider.AntiFraudProvider;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.AntiFraudProviderImpl;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.client.AntiFraudClient;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dao.AntiFraudDao;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dao.AntiFraudDaoImpl;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.newstartup.litepaymentservice.application.dataprovider"})
public class AntiFraudsSetup {


    @Bean
    public AntiFraudProvider antiFraudProvider(AntiFraudDao dao){
        return new AntiFraudProviderImpl(dao);
    }

    @Bean AntiFraudDao antiFraudDao(AntiFraudClient client, WireMockServer mockServer){
        return new AntiFraudDaoImpl(client, mockServer);
    }
}
