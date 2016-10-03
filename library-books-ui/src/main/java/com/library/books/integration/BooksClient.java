package com.library.books.integration;

import com.library.books.integration.common.Book;
import com.library.books.integration.common.BooksResponse;
import org.springframework.stereotype.Component;

/**
 * Created by skylar on 13.07.16.
 */
@Component
public class BooksClient extends AbstractApplicationClient {

    private static final String SEARCH_BOOKS = "/api/book/search/{pageNumber}/{recordsNumber}";
    private static final String ADD_BOOK     = "/api/book/add";
    private static final String FIND_BOOK    = "/api/book/find/{id}";
    private static final String REMOVE_BOOK  = "/api/book/remove/{id}";

    public BooksResponse searchBooks(int pageNumber, int recordsNumber) throws Exception {
        return performEmptyPostRequest(
                endpoint(SEARCH_BOOKS),
                BooksResponse.class,
                pageNumber, recordsNumber);
    }

    public AbstractResponse addBook(Book book) throws Exception {
        return performPostRequest(
                endpoint(ADD_BOOK),
                book,
                Response.class
        );
    }

    public BooksResponse findBook(String id) {
        return performGetRequest(
                endpoint(FIND_BOOK),
                BooksResponse.class,
                id
        );
    }

    public AbstractResponse removeBook(String id) {
        return performEmptyPostRequest(
                endpoint(REMOVE_BOOK),
                Response.class,
                id
        );
    }

}
