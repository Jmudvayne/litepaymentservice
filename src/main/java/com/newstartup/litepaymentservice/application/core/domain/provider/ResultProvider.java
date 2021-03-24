package com.newstartup.litepaymentservice.application.core.domain.provider;

import com.newstartup.litepaymentservice.application.core.domain.Result;

/**
 * The provider that manage the write operation around {@link Result}
 */
public interface ResultProvider {

    /**
     * Adds a {@link Result} to the application data store
     * @param result the object to be added
     * @return the saved {@link Result} instance
     */
    Result add(Result result);
}
