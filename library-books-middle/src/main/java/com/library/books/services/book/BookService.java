package com.library.books.services.book;

import com.library.books.integration.dto.Book;

import java.util.List;

/**
 * Created by skylar on 19.07.16.
 */
public interface BookService {

    /**
     * Search books by interval.
     *
     * @param pageNumber - page number
     * @param recordsNumber   - count of books in page
     * @return list all finds book by interval
     * @throws IllegalArgumentException - if variable pageNumber or recordsNumber equal 0
     * @throws Exception                - if was throw error when service try extract data from database
     */
    List<Book> searchBooks(int pageNumber, int recordsNumber) throws Exception;

}
