package com.library.books.repository;

import com.library.books.dto.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by skylar on 21.07.16.
 */
@Transactional
public interface BookRepository extends Repository, CrudRepository<Book, String> {}
