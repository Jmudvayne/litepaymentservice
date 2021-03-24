/*
 *  New StartUp  - Copyright (c) 2021.
 *  https://www.newstartup.com
 *
 */

package com.newstartup.litepaymentservice.application.configuration.entrypoint;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.newstartup.litepaymentservice.application.entrypoint")
public class EntryPointsSetup {
    // -----------------------------------------------------------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------------------------------------------------------

    private static final String API_VERSION = "1.0";
    private static final String API_TITLE = "New StartUp Lite Payment Service";
    private static final String API_DESCRIPTION = "A Rest API made for manage credit card transactions";

    // -----------------------------------------------------------------------------------------------------------------
    // Beans definition
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Configures Swagger
     *
     * @return a {@link Docket} instance
     */
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(getPaths())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    /**
     * A request filter that will log every single request that arrives
     * to the application
     *
     * @return a {@link CommonsRequestLoggingFilter} instance
     */
    @Bean public CommonsRequestLoggingFilter logFilter() {

        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludePayload(true);
        filter.setIncludeHeaders(false);
        filter.setBeforeMessagePrefix("Incoming request : ");
        filter.setAfterMessagePrefix("Request successfully processed, request data: ");
        return filter;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Helper Methods
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns an abstraction of the basic API info
     * in order to include it into the API documentation
     *
     * @return an {@link ApiInfo} instance
     */
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version(API_VERSION)
                .build();
    }

    /**
     * Returns a predicate with a regex in order to exclude
     * the Spring error controllers from the Swagger documentation
     *
     * @return a {@link Predicate} with the path regex
     */
    @SuppressWarnings("Guava")
    private Predicate<String> getPaths() {

        return Predicates.not(PathSelectors.regex("/error"));
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

}
