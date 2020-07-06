package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Service
public class StudentDaoImpl {
	List<Student> std=new ArrayList<Student>();
	
	@PostConstruct
	public void addStudents() {
		std.add(new Student(10,"Atmadeep","Paul"));
		std.add(new Student(20,"Dipali","Paul"));
		std.add(new Student(30,"Usha","Kandala"));
		
	}
	
	public List<Student> showStudents() {
		return std;
	}

}
