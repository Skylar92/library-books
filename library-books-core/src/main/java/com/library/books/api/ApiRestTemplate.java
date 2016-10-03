package com.library.books.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;

/**
 * Created by mhalych on 10/3/2016.
 */
public class ApiRestTemplate extends RestTemplate {

    private MultiValueMap<String, String> multiValueMap;

    public ApiRestTemplate() {
        multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
    }

    @Override
    protected <T> RequestCallback httpEntityCallback(Object requestBody, Type responseType) {
        HttpEntity<?> httpEntity = new HttpEntity<>(requestBody, multiValueMap);
        return super.httpEntityCallback(httpEntity, responseType);
    }
}
