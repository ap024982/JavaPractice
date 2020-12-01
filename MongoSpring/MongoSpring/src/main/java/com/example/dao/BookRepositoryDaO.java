package com.example.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Book;

@Repository
public interface BookRepositoryDaO extends MongoRepository<Book,String> {
	

}
