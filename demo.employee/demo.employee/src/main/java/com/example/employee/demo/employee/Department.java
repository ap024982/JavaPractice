package com.example.employee.demo.employee;

public class Department {
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	String location;
	public Department(int iId,String sName,String sLocation) {
		id=iId;
		name=sName;
		location=sLocation;
	}

}
