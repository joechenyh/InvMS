package com.nus.invms.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee{
	
	int ID;
	String username;
	String password;
	String status;
	String position;
	String name;
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}

}
