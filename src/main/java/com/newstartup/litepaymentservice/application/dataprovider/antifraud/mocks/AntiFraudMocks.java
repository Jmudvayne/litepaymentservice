package com.newstartup.litepaymentservice.application.dataprovider.antifraud.mocks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.newstartup.litepaymentservice.application.dataprovider.antifraud.rest.dto.AntiFraudResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

/**
 * Class to setup the mock response for the anti fraud service
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
public class AntiFraudMocks {

    // -----------------------------------------------------------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Private constructor made in order to prevent instantiation
     */
    private AntiFraudMocks(){
        //empty
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Setup mock response for failed validation
     *
     * @param mockService the {@link WireMockServer}
     * @throws IOException
     */
    public static void setupMockFailedValidation(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/validate"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                                copyToString(
                                        AntiFraudResponseDto.class.getClassLoader().getResourceAsStream("mocks/antifraud_failedValidation.json"),
                                        defaultCharset()))));
    }

    /**
     * Setup mock response for success validation
     *
     * @param mockService the {@link WireMockServer}
     * @throws IOException
     */
    public static void setupMockSuccessValidation(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/validate"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                                copyToString(
                                        AntiFraudResponseDto.class.getClassLoader().getResourceAsStream("mocks/antifraud_successValidation.json"),
                                        defaultCharset()))));
    }

}
