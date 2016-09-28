package com.library.books.integration.common;

import com.library.books.integration.Response;

import java.util.List;

/**
 * Created by mhalych on 9/28/2016.
 */
public class BooksResponse extends Response {

    private List<Book> books;

    public BooksResponse(List<Book> books) {
        super(false, null);
        this.books = books;
    }

    public BooksResponse() {
        super(false, null);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BooksResponse that = (BooksResponse) o;

        return books != null ? books.equals(that.books) : that.books == null;

    }

    @Override
    public int hashCode() {
        return books != null ? books.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BooksResponse{" +
                "books=" + books +
                '}';
    }
}
