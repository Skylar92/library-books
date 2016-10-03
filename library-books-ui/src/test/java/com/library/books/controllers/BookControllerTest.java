package com.library.books.controllers;

import com.google.gson.*;
import com.library.books.exceptions.ErrorCode;
import com.library.books.exceptions.ServerException;
import com.library.books.handlers.GlobalClientExceptionHandler;
import com.library.books.integration.BooksClient;
import com.library.books.integration.Response;
import com.library.books.integration.common.Book;
import com.library.books.integration.common.BooksResponse;
import com.library.books.responses.book.SearchBookResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * todo change static code 'http://localhost:8080/' to dynamic value
 * Created by skylar on 13.07.16.
 */
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BooksClient bookService;

    private MockMvc mockMvc;
    private Gson gson;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(bookController)
                .setControllerAdvice(new GlobalClientExceptionHandler()).build();
    }

    @Test
    public void shouldBeResponseOkWhenCallSearchBooksWithNormalParameters() throws Exception {
        List<Book> fixtureBooks = createFixtureListBooks();
        BooksResponse selectSearchBooks = new BooksResponse(fixtureBooks);

        Mockito.when(bookService.searchBooks(Mockito.anyInt(), Mockito.anyInt())).thenReturn(selectSearchBooks);
        MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/book/search/1/10")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        Mockito.verify(bookService, Mockito.only()).searchBooks(1, 10);
        String responseJson = mvcResult.getResponse().getContentAsString();
        SearchBookResponse response = gson.fromJson(responseJson, SearchBookResponse.class);
        assertFalse(response.isError());
        assertNull(response.getMessage());
        assertEquals(response.getBooks().size(), 3);
    }

    @Test
    public void shouldBeResponseFailWhenBookServiceThrowException() throws Exception {
        Mockito.when(bookService.searchBooks(Mockito.anyInt(), Mockito.anyInt())).thenThrow(new IllegalArgumentException("Something bad"));
        MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/book/search/1/10")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isInternalServerError())
                .andReturn();
        Mockito.verify(bookService, Mockito.only()).searchBooks(1, 10);
        String responseJson = mvcResult.getResponse().getContentAsString();
        Response response = gson.fromJson(responseJson, Response.class);
        assertTrue(response.isError());
        assertEquals("Something bad", response.getMessage());
    }

    @Test
    public void shouldBeResponseFailWhenBookServiceThrowServerException() throws Exception {
        Mockito.when(bookService.searchBooks(Mockito.anyInt(), Mockito.anyInt())).thenThrow(new ServerException(ErrorCode.UNKNOWN, "Something bad"));
        MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/book/search/1/10")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        Mockito.verify(bookService, Mockito.only()).searchBooks(1, 10);
        String responseJson = mvcResult.getResponse().getContentAsString();
        Response response = gson.fromJson(responseJson, Response.class);
        assertTrue(response.isError());
        assertEquals("Something bad", response.getMessage());
    }

    @Test
    public void shouldBeResponseNotFoundWhenCallSearchBooksWithMissingParameters() throws Exception {
        mockMvc.perform(post("/search/1")).andExpect(status().isNotFound());
    }

    @Test
    public void shouldResponseOkWhenCallAddBookWithNormalParameters() throws Exception {
        Book book = createDefaultBook();
        System.out.println(gson.toJson(book));
        Mockito.when(bookService.addBook(Mockito.any())).thenReturn(Response.ok());
        MvcResult mvcResult = mockMvc.perform(post("http://localhost:8080/book/add")
                .content(gson.toJson(book))
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        String responseJson = mvcResult.getResponse().getContentAsString();
        Response response = gson.fromJson(responseJson, Response.class);
        assertFalse(response.isError());
        assertNull(response.getMessage());
    }

    //------------------------------------------------------------------------

    private Book createDefaultBook() {
        Book book = new Book();
        book.setTitle("title");
        book.setDescription("description");
        book.setRating(1.5F);
        book.setAuthor("Author");
        book.setCode("ER23230-12");
        book.setDatePublication(new Date());
        book.setYear(2012);
        return book;
    }

    private List<Book> createFixtureListBooks() {
        List<Book> fixtureBooks = new ArrayList<>();
        fixtureBooks.add(new Book());
        fixtureBooks.add(new Book());
        fixtureBooks.add(new Book());
        return fixtureBooks;
    }

}