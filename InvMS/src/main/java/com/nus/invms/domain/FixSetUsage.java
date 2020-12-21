package com.nus.invms.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
//@Table only needed if table different name 
public class FixSetUsage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;

	@OneToOne
	private FixSet fixset; 
	
/*	@OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="FixSetUsage", joinColumns={@JoinColumn(name="PartUsage", referencedColumnName="PartUsage")}
    , inverseJoinColumns={@JoinColumn(name="PartUsage_ID", referencedColumnName="transactionId")}) */
	@OneToMany
	@ElementCollection
	private List<PartUsage> partusages;
	
	// @Column(name="employeeId", nullable=false
	@OneToOne
		private Employee employee;

		@FutureOrPresent
		@DateTimeFormat(pattern = "dd-MM-yyyy")
		// @Column(name="date", nullable=false)
		private LocalDate usagedate;

		// @Column(name="carplate", nullable=false)
		private String carplate;
		
		
		Status status;
		
		
		
		

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public FixSet getFixset() {
			return fixset;
		}

		public void setFixset(FixSet fixset) {
			this.fixset = fixset;
		}

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}

		public LocalDate getUsagedate() {
			return usagedate;
		}

		public void setUsagedate(LocalDate usagedate) {
			this.usagedate = usagedate;
		}

		public String getCarplate() {
			return carplate;
		}

		public void setCarplate(String carplate) {
			this.carplate = carplate;
		}

		@Override
		public String toString() {
			return "FixSetUsage [transactionId=" + transactionId + ", fixset=" + fixset + ", employee=" + employee
					+ ", usagedate=" + usagedate + ", carplate=" + carplate + "]";
		}

		

		public FixSetUsage(FixSet fixset, PartUsage partusage, Employee employee, @FutureOrPresent LocalDate usagedate,
				String carplate, Status status) {
			super();
			this.fixset = fixset;
			this.partusage = partusage;
			this.employee = employee;
			this.usagedate = usagedate;
			this.carplate = carplate;
			this.status = status;
		}

		public FixSetUsage() {
			super();
		}
	
		
	

}

