package com.library.books.controllers;

import com.library.books.integration.BooksClient;
import com.library.books.integration.AbstractResponse;
import com.library.books.integration.Response;
import com.library.books.integration.common.BooksResponse;
import com.library.books.responses.book.SearchBookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * Created by skylar on 13.07.16.
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class.getClass());

    @Autowired
    private BooksClient booksClient;

    //http://localhost:8080/book/search/1/10
    @RequestMapping(value = "/search/{pageNumber}/{recordsNumber}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public AbstractResponse searchBooks(@PathVariable("pageNumber") int pageNumber, @PathVariable("recordsNumber") int recordsNumber) throws Exception {
        logger.info(String.format("Search pageNumber %s with %s recordsNumber", pageNumber, recordsNumber));
        BooksResponse booksResponse = booksClient.searchBooks(pageNumber, recordsNumber);
        logger.info("Books founded", booksResponse.getBooks());
        return SearchBookResponse.createSearchBookResponse(booksResponse.getBooks());
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
