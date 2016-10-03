package com.library.books.integration;

import com.library.books.dto.Book;
import org.springframework.stereotype.Component;

/**
 * Created by mhalych on 9/30/2016.
 */
@Component
public class BookMapper implements Mapper<Book, com.library.books.integration.common.Book> {

    @Override
    public com.library.books.integration.common.Book convert(Book book, Class<com.library.books.integration.common.Book> aClass) {
        com.library.books.integration.common.Book bookResult = new com.library.books.integration.common.Book();
        bookResult.setAuthor(book.getAuthor());
        bookResult.setCode(book.getCode());
        bookResult.setDatePublication(book.getDatePublication());
        bookResult.setRating(book.getRating());
        bookResult.setDescription(book.getDescription());
        bookResult.setTitle(book.getTitle());
        return bookResult;
    }

    @Override
    public Book reverseConvert(com.library.books.integration.common.Book book, Class<Book> bookClass) {
        Book bookResult = new Book();
        bookResult.setAuthor(book.getAuthor());
        bookResult.setCode(book.getCode());
        bookResult.setDatePublication(book.getDatePublication());
        bookResult.setRating(book.getRating());
        bookResult.setDescription(book.getDescription());
        bookResult.setTitle(book.getTitle());
        return bookResult;
    }
}
