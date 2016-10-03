package com.library.books.responses.book;

import com.library.books.integration.Response;
import com.library.books.integration.common.Book;
import com.library.books.integration.common.BooksResponse;

/**
 * Created by mhalych on 10/3/2016.
 */
public class BookResponse extends Response {

    private Book book;

    public BookResponse(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookResponse that = (BookResponse) o;

        return book != null ? book.equals(that.book) : that.book == null;

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public static BookResponse createBookResponseFromBooksResponse(BooksResponse response) {
        Book book = response.getBooks().isEmpty() ? null : response.getBooks().get(0);
        return new BookResponse(book);
    }

    @Override
    public int hashCode() {
        return book != null ? book.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BookResponse{" +
                "book=" + book +
                '}';
    }
}
