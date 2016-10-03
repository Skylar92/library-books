package com.library.books.integration;

import com.library.books.exceptions.ServerInternalException;
import com.library.books.exceptions.ServerTemporaryNotWorkingException;
import com.library.books.properties.RestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.function.Supplier;

/**
 * Created by mhalych on 9/29/2016.
 */
public abstract class AbstractApplicationClient {

    private static final String EMPTY_REQUEST = "{}";

    @Autowired
    protected RestProperties restProperties;
    @Autowired
    protected RestTemplate restTemplate;

    protected <T extends AbstractResponse> T performEmptyPostRequest(String url, Class<T> aClass, Object... uriVariables) {
        return performRequest(() -> restTemplate.postForObject(url, EMPTY_REQUEST, aClass, uriVariables));
    }

    protected  <T extends AbstractResponse> T performRequest(Supplier<T> action) {
        T t = execute(action);
        if (t.isError())
            throw new ServerInternalException(t.getMessage());
        return t;
    }

    protected String endpoint(String address) {
        return getServerUrl() + address;
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
