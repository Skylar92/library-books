package com.library.books;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by skylar on 13.07.16.
 */
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class LibraryBooksUIStarter {

    public static void main(String... args) {
        SpringApplication.run(LibraryBooksUIStarter.class, args);
    }

    @Bean
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }

}
