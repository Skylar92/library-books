package com.library.books.integration.response.books;

import com.library.books.integration.dto.Book;
import com.library.books.integration.response.Response;

import java.util.List;

/**
 * Created by skylar on 20.09.16
 */
public class SelectSearchBooks extends Response {

    private List<Book> books;

    public SelectSearchBooks(List<Book> books) {
        super(false, null);
        this.books = books;
    }

    public SelectSearchBooks(boolean error, String message) {
        super(error, message);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "SelectSearchBooks{" +
                "books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectSearchBooks that = (SelectSearchBooks) o;

        return books != null ? books.equals(that.books) : that.books == null;

    }

    @Override
    public int hashCode() {
        return books != null ? books.hashCode() : 0;
    }
}
