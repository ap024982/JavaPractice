package org.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class department {

	public static void main(String[] args) {
		// TODO Auto-generated method stub  
		try{  
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//String instanceConnectionName = "avyukt";
		String databaseName = "employee";
		String IP_of_instance = "34.93.199.229";
		String username = "root";
		String password = "root";

		/*String jdbcUrl = String.format(
		    "jdbc:mysql://%s/%s/%s"
		        + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false",
		IP_of_instance,
		instanceConnectionName,
		databaseName
		);*/
		String jdbcUrl = String.format("jdbc:mysql://%s/%s"+"?useSSL=false", 
				IP_of_instance, databaseName);          
		System.out.println(jdbcUrl);
		Connection con = DriverManager.getConnection(jdbcUrl, username, password);
		//Connection con=DriverManager.getConnection(  
		//"jdbc:mysql://34.93.199.229:avyukt?socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false","root","root");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from department");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
		}  
		

	}


