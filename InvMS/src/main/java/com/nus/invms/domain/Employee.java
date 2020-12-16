package com.nus.invms.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int ID;
	String username;
	String epassword;
	String status;
	String position;
	String name;
	
	

	public Employee(String username, String epassword, String status, String position, String name) {
		super();
		this.username = username;
		this.epassword = epassword;
		this.status = status;
		this.position = position;
		this.name = name;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEPassword() {
		return epassword;
	}



	public void setEPassword(String password) {
		this.epassword = password;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Employee() {
		// TODO Auto-generated constructor stub
	}

}
