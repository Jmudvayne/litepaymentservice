package com.newstartup.litepaymentservice.application.configuration.dataprovider;

import com.newstartup.litepaymentservice.application.core.domain.provider.ResultProvider;
import com.newstartup.litepaymentservice.application.dataprovider.result.ResultProviderImpl;
import com.newstartup.litepaymentservice.application.dataprovider.result.dao.ResultDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.newstartup.litepaymentservice.application.dataprovider.result.dao")
public class ResultsSetup {

    /**
     * An implementation of {@link ResultProvider} that needs a
     * {@link ResultDao} implementations for its correct setup
     *
     * @param dao a required {@link ResultDao} implementation
     * @return a {@link ResultProvider} implementation
     */
    @Bean
    public ResultProvider resultsProvider(ResultDao dao) {

        return new ResultProviderImpl(dao);
    }


}
