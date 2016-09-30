package com.library.books.integration;

import com.library.books.integration.common.BooksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by skylar on 13.07.16.
 */
@Component
public class BooksClient extends AbstractApplicationClient {

    private static final String SEARCH_BOOKS = "/search/%s/%s";

    public BooksResponse searchBooks(int pageNumber, int recordsNumber) throws Exception {
        String endPoint = getServerUrl() + String.format(SEARCH_BOOKS, pageNumber, recordsNumber);
        return performRequest(endPoint, BooksResponse.class);
    }

}
