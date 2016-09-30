package com.library.books.integration;

import com.library.books.exceptions.ServerInternalException;
import com.library.books.exceptions.ServerTemporaryNotWorkingException;
import com.library.books.properties.RestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Created by mhalych on 9/29/2016.
 */
public abstract class AbstractApplicationClient {

    protected static final MediaType DEFAULT_MEDIA_TYPE = MediaType.APPLICATION_JSON_UTF8;

    @Autowired
    protected RestProperties restProperties;
    @Autowired
    protected RestTemplate restTemplate;

    protected <T extends AbstractResponse> T performRequest(String url, Class<T> aClass) {
        return performRequest(() -> restTemplate.postForObject(url, DEFAULT_MEDIA_TYPE, aClass));
    }

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
