package com.library.books.controllers;

import com.library.books.integration.AbstractResponse;
import com.library.books.integration.Response;
import com.library.books.integration.common.Book;
import com.library.books.integration.common.BooksResponse;
import com.library.books.services.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * skylar
 */
@RestController
@RequestMapping("api/book")
public class BookServiceController {

    @Autowired
    private BookService bookService;

    //http://localhost:8080/api/book/search/1/10
    @RequestMapping(value = "/search/{pageNumber}/{recordsNumber}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public AbstractResponse searchBooks(@PathVariable("pageNumber") int pageNumber, @PathVariable("recordsNumber") int recordsNumber) throws Exception {
        List<Book> books = bookService.searchBooks(pageNumber, recordsNumber);
        return new BooksResponse(books);
    }

    //http://localhost:8080/book/find/1
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public AbstractResponse findBook(@PathVariable("id") String id) throws Exception {
        Book book = bookService.findBook(id);
        return new BooksResponse(Collections.singletonList(book));
    }

    //http://localhost:8080/book/remove/1
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public AbstractResponse removeBook(@PathVariable("id") String id) throws Exception {
        bookService.removeBook(id);
        return Response.ok();
    }

    //http://localhost:8080/book/add
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AbstractResponse addBook(@RequestBody Book book) throws Exception {
        bookService.addBook(book);
        return Response.ok();
    }


}
