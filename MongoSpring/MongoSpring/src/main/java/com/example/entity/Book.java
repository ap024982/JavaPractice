package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="test")
public class Book {

	
	@Id
	public String id;
	
	@Field(value="bookName")
	public String bookName;
	
	@Field(value="bookDescription")
	public String bookDescription;
	
	public Book() {}
	
	public Book(String strName, String strDes) {
		bookName=strName;
		bookDescription=strDes;
	}
	


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}


	

	public String getBookName() {
		return bookName;
	}


	public String getBookDescription() {
		return bookDescription;
	}


	
}
