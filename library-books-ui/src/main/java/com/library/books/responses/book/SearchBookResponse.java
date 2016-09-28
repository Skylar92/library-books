package com.library.books.responses.book;

import com.library.books.integration.Response;
import com.library.books.integration.common.Book;

import java.util.List;


/**
 * Created by skylar on 19.07.16.
 */
public class SearchBookResponse extends Response {

    private List<Book> books;

    public SearchBookResponse() {
        super(false, null);
    }

    public SearchBookResponse(boolean error, String message) {
        super(error, message);
    }

    public SearchBookResponse(boolean error, String message, List<Book> books) {
        super(error, message);
        this.books = books;
    }

    public static SearchBookResponse createSearchBookResponse(List<Book> books) {
        return new SearchBookResponse(false, null, books);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
