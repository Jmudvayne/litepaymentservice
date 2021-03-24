package com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dao;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.newstartup.litepaymentservice.application.core.domain.ProcessTransaction;
import com.newstartup.litepaymentservice.application.core.domain.ValidationResponse;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.mocks.AntiFraudMocks;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.client.AntiFraudClient;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto.AntiFraudRequestDto;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto.AntiFraudResponseDto;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto.mapper.AntiFraudMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.io.IOException;

/**
 * An implementation of {@link AntiFraudDao}
 * that requires a {@link AntiFraudClient} to retrieve the data

 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Slf4j
@RequiredArgsConstructor
public class AntiFraudDaoImpl implements AntiFraudDao{

    // -----------------------------------------------------------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The client in charge of the anti fraud validation
     */
    private final AntiFraudClient antiFraudClient;

    /**
     * The WireMockServer for the anti fraud service
     */
    private final WireMockServer mockAntiFraudService;

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Mono<ValidationResponse> validate(ProcessTransaction processTransaction) {
        try {
            setupMockResponse(Integer.parseInt(processTransaction.getCard().getCvv2()));

        } catch (IOException e) {
            log.error("Error in setup mock anti fraud", e);
        }

        return getValidationFromAntiFraudClien(AntiFraudMapper.map(processTransaction))
                .map(antiFraudResponseDto -> AntiFraudMapper.mapResponse(antiFraudResponseDto,processTransaction))
                .doOnNext(Mono::just);
    }

    /**
     * Performs a post request to the anti fraud service
     * @param antiFraudRequestDto the {@AntiFraudRequestDto} with the data to validate
     * @return a {@link Mono<AntiFraudResponseDto>}
     */
    private Mono<AntiFraudResponseDto> getValidationFromAntiFraudClien(AntiFraudRequestDto antiFraudRequestDto){
        return Mono.just(antiFraudClient.validateTransaction(antiFraudRequestDto));
    }

    /**
     * Setup the mock response depending on the give flag,
     * if the flag is pair the response is success, otherwise is failed
     * @param flag  The flag to indicate the response to setup
     * @throws IOException
     */
    private void setupMockResponse(int flag) throws IOException {

        if (flag % 2 == 0) {
            AntiFraudMocks.setupMockSuccessValidation(mockAntiFraudService);
        } else {
            AntiFraudMocks.setupMockFailedValidation(mockAntiFraudService);
        }

    }
}
