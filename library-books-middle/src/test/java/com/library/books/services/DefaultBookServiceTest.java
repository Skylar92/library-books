package com.library.books.services;

import com.library.books.integration.AbstractResponse;
import com.library.books.integration.common.BooksResponse;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

/**
 * Created by skylar on 21.07.16.
 */
public class DefaultBookServiceTest {

    @Test
    public void shouldBeFindFiveBooksInFirstPage() {

    }

    @Test
    public void shouldBeThrowExceptionWhenPageNumberIsZero() {

    }

    @Test
    public void shouldBeThrowExceptionWhenPageSizeIsZero() {

    }

    @Test
    public void shouldBeThrowExceptionWhenDatabaseIsFail() {

    }

    @Test
    public void shouldBeEmptyListIfCountBooksInDatabaseIsZero() {

    }

}