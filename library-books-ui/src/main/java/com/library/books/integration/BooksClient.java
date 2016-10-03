package com.library.books.integration;

import com.library.books.integration.common.BooksResponse;
import org.springframework.stereotype.Component;

/**
 * Created by skylar on 13.07.16.
 */
@Component
public class BooksClient extends AbstractApplicationClient {

    private static final String SEARCH_BOOKS = "/api/book/search/{pageNumber}/{recordsNumber}";

    public BooksResponse searchBooks(int pageNumber, int recordsNumber) throws Exception {
        return performEmptyPostRequest(
                endpoint(SEARCH_BOOKS),
                BooksResponse.class,
                pageNumber, recordsNumber);
    }

}
