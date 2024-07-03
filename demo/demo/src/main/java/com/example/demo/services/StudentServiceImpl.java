package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.StudentDaoImpl;
import com.example.demo.model.Student;

public class StudentServiceImpl implements StudentService {
	
	
	StudentDaoImpl stdImpl=new StudentDaoImpl();
	
	public List<Student> getData() {
		//stdImpl.addStudents();
		return stdImpl.showStudents();
	}

}
