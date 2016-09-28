package com.library.books.storage;

import com.library.books.integration.common.Book;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by skylar on 21.07.16.
 */
@Component
public class LocalStorageBook implements StorageBook {

    @Override
    public int getCountBooks() {
        return 0;
    }

    @Override
    public List<Book> findBooksBetween(int from, int to) {
        return null;
    }
}
