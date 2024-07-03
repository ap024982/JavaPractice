package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;
import com.example.demo.services.StudentServiceImpl;

@ComponentScan("com.example")
@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class StudentsApplication {
	
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("C:\\Users\\atpaul\\Documents\\Java Programs\\demo\\demo\\src\\main\\resources\\Configuration\\Application.xml");
	StudentService std=(StudentServiceImpl)ctx.getBean("stdservice");
	/*@Autowired
	@Qualifier("StudentServiceImpl")
	StudentService std;*/
	
	@GetMapping("/allStudents")
	public List<Student> getAllStudents(){
		System.out.println("hi");
		return std.getData();
	}

	public static void main(String[] args) {
		
		ApplicationContext ctx1 = new ClassPathXmlApplicationContext("C:\\Users\\atpaul\\Documents\\Java Programs\\demo\\demo\\src\\main\\resources\\Configuration\\Application.xml");
		StudentsApplication std1=(StudentsApplication)ctx1.getBean("stdapp");
		SpringApplication.run(StudentsApplication.class, args);
	}

}
