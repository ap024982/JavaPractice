package com.example.MongoSpring;

import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.BookService;
import com.example.entity.Book;



@RestController
public class MongoController {

	@Autowired
	BookService book1;
	
    @RequestMapping(method=RequestMethod.GET, value="/getAllDocuments")
    public List<Book> getData() {
       return book1.findAllBooks();   	

    }
    
    @PostMapping("/saveDocuments")
    public Book saveData(@RequestBody Book b2) {
    	return book1.saveBook(b2) ; 	

    }
    
    @GetMapping("/searchDocument")
    public List<Book> getBookbyName(@RequestBody Book b2) {
        System.out.println("Searching");
        return book1.findBook(b2); 	

    }
    
    
    
}
