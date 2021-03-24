package com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.client;

import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto.AntiFraudRequestDto;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto.AntiFraudResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The rest client configured to consume an anti fraud service
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@FeignClient(value = "antifraud-client", decode404 = true , url="${antifraud.service.url}")
public interface AntiFraudClient {

    /**
     * Return the result of the anti fraud validation
     * @param antiFraudRequestDto the {@link AntiFraudRequestDto}
     * @return the {@link AntiFraudResponseDto}
     */
    @PostMapping(value = "/validate")
    AntiFraudResponseDto validateTransaction(AntiFraudRequestDto antiFraudRequestDto);
}
