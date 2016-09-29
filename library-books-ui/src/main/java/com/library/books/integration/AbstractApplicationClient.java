package com.library.books.integration;

import com.library.books.exceptions.ServerInternalException;
import com.library.books.exceptions.ServerTemporaryNotWorkingException;
import com.library.books.properties.RestProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Supplier;

/**
 * Created by mhalych on 9/29/2016.
 */
public abstract class AbstractApplicationClient {

    @Autowired
    protected RestProperties restProperties;

    protected  <T extends AbstractResponse> T performRequest(Supplier<T> action) {
        T t = execute(action);
        if (t.isError())
            throw new ServerInternalException(t.getMessage());
        return t;
    }

    protected String getServerUrl() {
        return restProperties.getServerUrl();
    }

    private <T extends AbstractResponse> T execute(Supplier<T> action) {
        try {
            return action.get();
        } catch (Throwable ex) {
            throw new ServerTemporaryNotWorkingException(ex);
        }
    }
}
