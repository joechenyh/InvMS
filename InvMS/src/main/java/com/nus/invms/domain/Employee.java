
package com.nus.invms.domain;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Employee{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@NotEmpty
	private String name;
	@NotEmpty
	@Size(min=5, max=20)
	@Column(unique=true)
	private String username;
	@NotEmpty
	@Size(min=5, max=20)
	private String epassword;
	
	private Status status;
	private RoleType role;
	
	@OneToMany (mappedBy="employee") 
	private Collection<PartUsage> partUsages;

	@OneToMany (mappedBy="employee")
	private Collection<Order> orders;
	
	public Employee(@NotEmpty String name, @NotEmpty @Size(min = 5, max = 20) String username,
			@NotEmpty @Size(min = 5, max = 20) String epassword, Status status, RoleType role) {
		super();
		this.name = name;
		this.username = username;
		this.epassword = epassword;
		this.status = status;
		this.role = role;
	}



	public String getUsername() {
		return username;
	}



	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		this.ID = iD;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	public Collection<PartUsage> getUsages() {
		return partUsages;
	}

	public void setUsages(Collection<PartUsage> usages) {
		this.partUsages = usages;
	}

	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
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



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public RoleType getRole() {
		return role;
	}



	public void setRole(RoleType role) {
		this.role = role;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
		super();
	}



	

}
