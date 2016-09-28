package com.library.books.services.book;

import com.library.books.integration.common.Book;
import com.library.books.storage.StorageBook;
import com.library.books.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by skylar on 21.07.16.
 */
@Service
public class DefaultBookService implements BookService {

    @Autowired
    private StorageBook storageBook;

    @Override
    public List<Book> searchBooks(int pageNumber, int recordsNumber) throws Exception {
        ValidationUtils.throwExceptionIfValueZero(pageNumber);
        ValidationUtils.throwExceptionIfValueZero(recordsNumber);
        int countBooks = storageBook.getCountBooks();
        int to = pageNumber * recordsNumber;
        int from = to - recordsNumber;
        if (to > countBooks) to = countBooks;
        return storageBook.findBooksBetween(from, to);
    }
}
