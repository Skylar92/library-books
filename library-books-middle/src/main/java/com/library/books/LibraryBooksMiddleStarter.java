package com.library.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mhalych on 9/30/2016.
 */
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class LibraryBooksMiddleStarter {

    public static void main(String... args) {
        SpringApplication.run(LibraryBooksMiddleStarter.class, args);
    }

}
