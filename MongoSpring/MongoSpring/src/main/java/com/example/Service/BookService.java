package com.example.Service;

import java.util.List;

import com.example.entity.Book;

public interface BookService {

	public List<Book> findAllBooks();
	public Book saveBook(Book book);
	public List<Book> findBook(Book b);
	
	
}
