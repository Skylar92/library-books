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
    public AbstractResponse searchBooks(@PathVariable("pageNumber") int pageNumber, @PathVariable("recordsNumber") int recordsNumber) {
        try {
            List<Book> books = bookService.searchBooks(pageNumber, recordsNumber);
            return new BooksResponse(books);
        } catch (Exception ex) {
            //print stack trace
            return Response.fail(ex.getMessage());
        }
    }

    //http://localhost:8080/book/find/1
    @RequestMapping(value = "/find/{id}", method = RequestMethod.POST)
    public AbstractResponse findBook(@PathVariable("id") long id) {
        return Response.ok();
    }

    //http://localhost:8080/book/remove/1
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public AbstractResponse removeBook(@PathVariable("id") long id) {
        return Response.ok();
    }

    //http://localhost:8080/book/add
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AbstractResponse addBook() {
        return Response.ok();
    }


}
