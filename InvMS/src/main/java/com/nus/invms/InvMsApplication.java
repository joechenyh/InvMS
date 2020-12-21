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


		return args -> 
		{

			Employee e1 = new Employee("John Doe", "qwerty", "qwerty", Status.ACTIVE, RoleType.ADMIN); 
			Employee e2 = new Employee("Mechanic", "mechanic", "password", Status.ACTIVE, RoleType.MECHANIC); 
			Employee e3 = new Employee("Admin", "admin", "password", Status.ACTIVE, RoleType.ADMIN); 
			erepo.save(e1);
			erepo.save(e2);
			erepo.save(e3);
			
			Supplier s1 = new Supplier("Spare Part Supplier Company", Status.ACTIVE, "91276332", "1 Heng Mui Keng Terrace", "sparepart@gmail.com");
			srepo.save(s1);
			
			Product p1 = new Product(1001, 10, 20, "Sample Product Name", "Sample Description", "Red", "Sample Dimension", "Sample Manufacturer", "Shelf 1A", 23.00, Status.ACTIVE);
			prepo.save(p1);
			Product p2 = new Product(1002, 11, 22, "Sample Product Name", "Sample Description", "Red", "Sample Dimension", "Sample Manufacturer", "Shelf 1A", 25.00, Status.ACTIVE);
			prepo.save(p2);
			

			Inventory i21 = new Inventory(1, "Random Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i2 = new Inventory(2, "King Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i3 = new Inventory(3, "Singa Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i4 = new Inventory(4, "Coco Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i5 = new Inventory(5, "Alan Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i6 = new Inventory(6, "Taka Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i7 = new Inventory(7, "Lee Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i8 = new Inventory(8, "Rocky Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i9 = new Inventory(9, "Metal Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i10 = new Inventory(10, "Caterpillar Brand", "This stock is on special offer", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i11 = new Inventory(1, "Random Brand", "This stock is expiring soon", "Car Parts", "Tyres", "Tyres for Rainy Days", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i12 = new Inventory(2, "King Brand", "This stock is expiring soon", "Car Parts", "Tyres", "Tyres for Rainy Days", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i13 = new Inventory(3, "Singa Brand", "This stock is expiring soon", "Car Parts", "Tyres", "Tyres for Rainy Days", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i14 = new Inventory(4, "Coco Brand", "This stock is expiring soon", "Car Parts", "Tyres", "Tyres for Rainy Days", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i15 = new Inventory(5, "Alan Brand", "This stock is expiring soon", "Car Parts", "Tyres", "Tyres for Rainy Days", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i16 = new Inventory(6, "Taka Brand", "This stock is expiring soon", "Car Parts", "Tyres", "Tyres for Rainy Days", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i17 = new Inventory(7, "Lee Brand", "This stock is expiring soon", "Car Parts", "Tyres", "Tyres for Rainy Days", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i18 = new Inventory(8, "Rocky Brand", "This stock is expiring soon", "Car Parts", "Tyres", "Tyres for Rainy Days", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i19 = new Inventory(9, "Metal Brand", "This stock is expiring soon", "Car Parts", "Tyres", "Tyres for Rainy Days", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());
			Inventory i20 = new Inventory(10, "Caterpillar Brand", "This stock is expiring soon", "Car Parts", "Tyres", "Tyres for Rainy Days", 23.00, 35.00, 47.00, 96.00, "Anti Skid Tyre with ultra hard rubber", 35, p1, s1, s1.getSupplierName());

			Inventory i1 = new Inventory(1, "Nike", "lala", "Big", "There", "here", 12.00, 13.00, 14.00, 15.00, "Sample Product Name", 100, p1, s1, "Spare Part Supplier Company");

			irepo.save(i1);

			irepo.save(i2);
			irepo.save(i3);
			irepo.save(i4);
			irepo.save(i5);
			irepo.save(i6);
			irepo.save(i7);
			irepo.save(i8);
			irepo.save(i9);
			irepo.save(i10);
			irepo.save(i11);
			irepo.save(i12);
			irepo.save(i13);
			irepo.save(i14);
			irepo.save(i15);
			irepo.save(i16);
			irepo.save(i17);
			irepo.save(i18);
			irepo.save(i19);
			irepo.save(i20);
			irepo.save(i21);


			PartUsage pu1 = new PartUsage(e1, p1.getPartNumber(), 2, LocalDate.now(), "SDV1234R");
				
			purepo.save(pu1);

			System.out.println("Team Alpha Bean - Ready to Run!");
	


	} ;
}
}
