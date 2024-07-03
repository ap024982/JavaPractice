package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import com.example.demo.services.StudentServiceImpl;


@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	StudentService std=new StudentServiceImpl();
	/*@Autowired
	StudentService std;*/
	
	@GetMapping("/allStudents")
	public List<Student> getAllStudents(){
		//System.out.println("hi");
		return std.getData();
	}

}
