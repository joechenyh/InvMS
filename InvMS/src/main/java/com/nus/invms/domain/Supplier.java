
package com.nus.invms.domain;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierId;
	
	@NotEmpty
	private String supplierName;
	private Status status;
	
	@NotEmpty
	private String phoneNumber;
	@NotEmpty
	private String address, emailAddress;
	
	@ManyToOne
	private Order order;
	
	public Supplier(String supplierName) {
		super();
		this.supplierName = supplierName;
	}

	public Supplier() {
		super();
	}


	

}
