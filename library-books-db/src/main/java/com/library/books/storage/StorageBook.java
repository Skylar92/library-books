package com.library.books.storage;

import com.library.books.integration.dto.Book;

import java.util.List;

/**
 * Created by skylar on 21.07.16.
 */
public interface StorageBook extends Storage {

    /**
     *
     * @return count of all books in storage
     */
    int getCountBooks();

    /**
     * Find books between interval
     * @param from - first book
     * @param to - last book
     * @return list of books between {from} and {to} values
     */
    List<Book> findBooksBetween(int from, int to);


}
