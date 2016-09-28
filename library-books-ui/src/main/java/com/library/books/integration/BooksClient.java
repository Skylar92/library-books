package com.library.books.integration;

import com.library.books.integration.common.BooksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by skylar on 13.07.16.
 */
@Component
public class BooksClient {

    @Autowired
    private RestTemplate template;

    public BooksResponse searchBooks(int pageNumber, int recordsNumber) throws Exception {
        return null;
    }

}
