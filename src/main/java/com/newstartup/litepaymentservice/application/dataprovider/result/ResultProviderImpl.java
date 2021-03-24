package com.newstartup.litepaymentservice.application.dataprovider.result;

import com.newstartup.litepaymentservice.application.core.domain.Result;
import com.newstartup.litepaymentservice.application.core.domain.provider.ResultProvider;
import com.newstartup.litepaymentservice.application.dataprovider.result.dao.ResultDao;
import com.newstartup.litepaymentservice.application.dataprovider.result.model.mapper.ResultDocumentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ResultProviderImpl implements ResultProvider {

    // -----------------------------------------------------------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The DAO in charge of the {@link Result} resource management
     */
    private final ResultDao dao;

    // -----------------------------------------------------------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Result add(Result result) {
        var transactionId = result.getTransactionId();
        log.trace("Adding execution result to the data store for the transaction with id: {}", transactionId);
        var savedDocument = dao.save(ResultDocumentMapper.map(result));
        log.trace("Execution result added to data store for authorization whit id: {}", transactionId);
        return result;

    }
}
