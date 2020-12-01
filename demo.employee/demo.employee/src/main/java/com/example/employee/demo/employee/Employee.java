package com.example.employee.demo.employee;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController("departments")
public class Employee {
	
	@RequestMapping(method=RequestMethod.GET,value="/getAllDept")
	public List<Department> getAllDepartments() throws ClassNotFoundException, SQLException, JsonProcessingException {
		//return ("New Department");
		//ObjectMapper mapper = new ObjectMapper();
		DepartmentImpl dept=new DepartmentImpl();
		List<Department> lst= dept.getDepartments();
		/*System.out.println("ABCDDDD");
		  String json = mapper.writeValueAsString(lst);
		  System.out.println(json);*/
		  return lst;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findDepartment")
	public List<Department> getDepartment(@RequestParam(name="location") String loc) throws ClassNotFoundException, SQLException, JsonProcessingException {
		//return ("New Department");
		//ObjectMapper mapper = new ObjectMapper();
		DepartmentImpl dept=new DepartmentImpl();
		List<Department> lst= dept.getDepartmentbyLoc(loc);
		/*System.out.println("ABCDDDD");
		  String json = mapper.writeValueAsString(lst);
		  System.out.println(json);*/
		  return lst;
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes = "application/json",value="/createDepartment")
	public void addDepartment(@RequestBody Department dept) throws ClassNotFoundException, SQLException, JsonProcessingException {
		DepartmentImpl dept1=new DepartmentImpl();
		dept1.addDepartment(dept);
		
		 // return lst;
	}

}
