package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;

@Component
public interface StudentService {
	public List<Student> getData();

}
