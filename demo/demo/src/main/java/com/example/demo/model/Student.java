package com.example.demo.model;

public class Student {
	int StudentID;
	String firstname;
	String lastname;
	
	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	public Student(int id, String strFirstName,String strLastName){
		StudentID=id;
		firstname=strFirstName;
		lastname=strLastName;
		
	}

}
