package com.nus.invms;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nus.invms.domain.Employee;
import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.Order;
import com.nus.invms.domain.OrderType;
import com.nus.invms.domain.PartUsage;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.RoleType;
import com.nus.invms.domain.Status;
import com.nus.invms.domain.Supplier;
import com.nus.invms.repo.EmployeeRepository;
import com.nus.invms.repo.InventoryRepository;
import com.nus.invms.repo.OrderRepository;
import com.nus.invms.repo.PartUsageRepository;
import com.nus.invms.repo.ProductRepository;
import com.nus.invms.repo.SupplierRepository;



@SpringBootApplication
public class InvMsApplication {
	
	//testtt
	
	@Autowired
	EmployeeRepository erepo; 
	
	@Autowired
	InventoryRepository irepo; 
	
	@Autowired
	OrderRepository orepo;
	
	@Autowired
	PartUsageRepository purepo; 
	
	@Autowired
	SupplierRepository srepo;
	
	@Autowired
	ProductRepository prepo;
	


	public static void main(String[] args) {
		SpringApplication.run(InvMsApplication.class, args);
		
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
	
	Employee e1 = new Employee("Joe Chen", "joechen", "password", Status.ACTIVE, RoleType.ADMIN); 
	Employee e2 = new Employee("Mechanic", "mechanic", "password", Status.ACTIVE, RoleType.MECHANIC); 
	Employee e3 = new Employee("Admin", "admin", "password", Status.ACTIVE, RoleType.ADMIN); 
	erepo.save(e1);
	erepo.save(e2);
	erepo.save(e3);
	
	Supplier s1 = new Supplier("ACME Company", Status.ACTIVE, "91276332", "1 Heng Mui Keng Terrace", "sparepart@gmail.com");
	Supplier s2 = new Supplier("ISS Company", Status.ACTIVE, "91276332", "1 Heng Mui Keng Terrace", "sparepart@gmail.com");
	
	srepo.save(s1);
	srepo.save(s2);
	
	Product p1 = new Product(744, 10, 20, "Product A", "A Sample Description", "Red", "Sample Dimension", "Stamford Car Parts", "Shelf 1A", 23.00, Status.ACTIVE);
	Product p2 = new Product(355, 3, 12, "Product B", "B Sample Description", "Black", "Another Dimension", "Michelin", "Shelf 2B", 47.00, Status.ACTIVE);
	prepo.save(p1);
	prepo.save(p2);
	
	Inventory i1 = new Inventory(1, "Random Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
	Inventory i2 = new Inventory(2, "Random Brand", "This stock is on special offer", "Car Windows", "Back Windows", "Unbreakable Windows", 24.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
	Inventory i3 = new Inventory(3, "Random Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 33.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p2, s2, s2.getSupplierName());
	Inventory i4 = new Inventory(4, "Random Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 99.00, 35.00, 17.00, 56.00, "Anti Skid Tyre with ultra hard rubber", 35, p2, s2, s2.getSupplierName());

	irepo.save(i1);
	irepo.save(i2);
	irepo.save(i3);
	irepo.save(i4);
	
	
	
	/*	Order o1 = new Order();*/
		
	

	System.out.println("Team Alpha Bean - Ready to Run!");
	
		};

	} 
}
