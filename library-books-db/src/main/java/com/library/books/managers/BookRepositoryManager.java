package com.library.books.managers;

import com.google.common.collect.Lists;
import com.library.books.dto.Book;
import com.library.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhalych on 9/30/2016.
 */
@Component
public class BookRepositoryManager {

    @Autowired
    private BookRepository bookRepository;

    public int getCountBooks() {
        return (int) bookRepository.count();
    }

    public List<Book> findBooksBetween(int from, int to) {
        Iterable<Book> all = bookRepository.findAll();
        ArrayList<Book> books = Lists.newArrayList(all);
        return books.subList(from, to);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void removeBook(String id) {
        bookRepository.delete(id);
    }

    public Book findBook(String id) {
        return bookRepository.findOne(id);
    }
}
