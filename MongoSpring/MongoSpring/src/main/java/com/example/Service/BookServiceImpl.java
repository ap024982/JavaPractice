package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dao.BookRepositoryDaO;
import com.example.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepositoryDaO bk;
	
	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return bk.findAll();
		
	}

	@Override
	public Book saveBook(Book b) {
		// TODO Auto-generated method stub
		return bk.save(b);
		
	}

	@Override
	public List<Book> findBook(Book b) {
		// TODO Auto-generated method stub
		Example e1=Example.of(b);
		return bk.findAll(e1);
	}

	

}
