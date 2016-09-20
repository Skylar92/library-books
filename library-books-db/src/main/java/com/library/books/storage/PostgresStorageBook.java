package com.library.books.storage;

import java.util.List;

//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;

import com.library.books.integration.dto.Book;

public class PostgresStorageBook implements StorageBook {
	
//	@Autowired
//	private SessionFactory sessionFactory;
//
	@Override
	public int getCountBooks() {
		return 0;
	}

	@Override
	public List<Book> findBooksBetween(int from, int to) {
		return null;
	}

}
