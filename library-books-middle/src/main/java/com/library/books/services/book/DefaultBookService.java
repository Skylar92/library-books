package com.library.books.services.book;

import com.library.books.integration.BookMapper;
import com.library.books.integration.common.Book;
import com.library.books.managers.BookRepositoryManager;
import com.library.books.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by skylar on 21.07.16.
 */
@Service
public class DefaultBookService implements BookService {

    @Autowired
    private BookRepositoryManager bookRepositoryManager;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> searchBooks(int pageNumber, int recordsNumber) throws Exception {
        ValidationUtils.throwExceptionIfValueZero(pageNumber);
        ValidationUtils.throwExceptionIfValueZero(recordsNumber);
        int countBooks = bookRepositoryManager.getCountBooks();
        int to = pageNumber * recordsNumber;
        int from = to - recordsNumber;
        if (to > countBooks) to = countBooks;
        return bookRepositoryManager.findBooksBetween(from, to).stream().map(book -> bookMapper.convert(book, Book.class)).collect(Collectors.toList());
    }
}
