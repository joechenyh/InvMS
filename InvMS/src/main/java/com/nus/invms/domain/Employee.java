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
@Data
@NoArgsConstructor
public class Employee{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	@NotEmpty
	private String name;
	@NotEmpty
	@Size(min=5, max=20)
	private String username;
	@NotEmpty
	@Size(min=5, max=20)
	private String password;
	
	private Status status;
	private RoleType role;
	
	@OneToMany (mappedBy="employee") 
	private Collection<Usage> usages;

	@OneToMany (mappedBy="employee")
	private Collection<Order> orders;
	
	public Employee(@NotEmpty String name, @NotEmpty @Size(min = 5, max = 20) String username,
			@NotEmpty @Size(min = 5, max = 20) String password, Status status, RoleType role) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.status = status;
		this.role = role;
	}
	


	

}
