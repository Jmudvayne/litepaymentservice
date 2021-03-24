package com.newstartup.litepaymentservice.application.configuration.dataprovider;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WireMockConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer mockAntiFraudService() {
        return new WireMockServer(9561);
    }

}
