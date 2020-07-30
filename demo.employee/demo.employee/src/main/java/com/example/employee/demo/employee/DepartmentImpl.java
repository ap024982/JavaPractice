package com.example.employee.demo.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentImpl {
	List<Department> lst=new ArrayList<Department>();
	public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
	 
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//String instanceConnectionName = "avyukt";
		String databaseName = "employee";
		String IP_of_instance = "34.93.199.229";
		String username = "root";
		String password = "root";
		String jdbcUrl = String.format("jdbc:mysql://%s/%s"+"?useSSL=false", 
				IP_of_instance, databaseName);          
		System.out.println(jdbcUrl);
		Connection con = DriverManager.getConnection(jdbcUrl, username, password);
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from department");  
		while(rs.next()) {
		int a=rs.getInt(1);
		String b=rs.getString(2);
		String c=rs.getString(3);
		System.out.println (a+b+c);
			lst.add(new Department(a,b,c)); 
		}
		con.close();
	return lst;
		
	}
	
	
	
	public List<Department> getDepartmentbyLoc(String loc) throws ClassNotFoundException, SQLException {
		 
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//String instanceConnectionName = "avyukt";
		String databaseName = "employee";
		String IP_of_instance = "34.93.199.229";
		String username = "root";
		String password = "root";
		String jdbcUrl = String.format("jdbc:mysql://%s/%s"+"?useSSL=false", 
				IP_of_instance, databaseName);          
		System.out.println(jdbcUrl);
		Connection con = DriverManager.getConnection(jdbcUrl, username, password);
		Statement stmt=con.createStatement();  
		String strQuery=String.format("select * from department where location='%s"+"'", loc);
		System.out.println(strQuery);
		ResultSet rs=stmt.executeQuery(strQuery); 
		while(rs.next()) {
		int a=rs.getInt(1);
		String b=rs.getString(2);
		String c=rs.getString(3);
		System.out.println (a+b+c);
			lst.add(new Department(a,b,c)); 
		}
		con.close();
	return lst;
		
	}

}
