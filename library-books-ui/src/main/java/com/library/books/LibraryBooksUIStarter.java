package com.library.books;


import com.library.books.runner.CommonBootRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by skylar on 13.07.16.
 */
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class LibraryBooksUIStarter extends CommonBootRunner {

    public static void main(String... args) {
        SpringApplication.run(LibraryBooksUIStarter.class, args);
    }

}
