package com.nus.invms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nus.invms.domain.Fixset;
import com.nus.invms.domain.Part;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.Status;
import com.nus.invms.repo.EmployeeRepository;
import com.nus.invms.repo.FixsetRepository;
import com.nus.invms.repo.InventoryRepository;
import com.nus.invms.repo.OrderRepository;
import com.nus.invms.repo.PartRepository;
import com.nus.invms.repo.PartUsageRepository;
import com.nus.invms.repo.ProductRepository;
import com.nus.invms.repo.SupplierRepository;

@SpringBootApplication
public class InvMsApplication {

	// test

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

	@Autowired
	PartRepository partrepo;

	@Autowired
	FixsetRepository fixrepo;

	public static void main(String[] args) {
		SpringApplication.run(InvMsApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			// System.out.println("Let's start to see our models! ");

			/*
			 * Employee e1 = new Employee();
			 * 
			 * Inventory i1 = new Inventory();
			 * 
			 * Order o1 = new Order();
			 * 
			 * PartUsage pu1 = new PartUsage();
			 * 
			 * Supplier s1 = new Supplier();
			 * 
			 * Product p1 = new Product();
			 * 
			 * 
			 * erepo.save(e1); irepo.save(i1); orepo.save(o1); purepo.save(pu1);
			 * srepo.save(s1); prepo.save(p1);
			 */

			
			
//			
			/*
			 * Product prod1 = new Product (12, 12, "tyre", "car tyre", "black", "20cm",
			 * "dunlop", "bottom", 120.0, Status.ACTIVE); Product prod2 = new Product (2, 2,
			 * "jockey tool", "jockey tool for car repair", "silver", "20cm", "mytool",
			 * "office", 20.0, Status.ACTIVE); Product prod3 = new Product (5, 5, "grease",
			 * "car grease", "black", "1 litre", "greeeeease", "top", 12.50, Status.ACTIVE);
			 * Product prod4 = new Product (1, 1,"motor engine", "motor engine replacement",
			 * "silver", "12kg", "engine centre", "middle", 70.0, Status.ACTIVE);
			 * prepo.save(prod1); prepo.save(prod2); prepo.save(prod3); prepo.save(prod4);
			 */
			  
//			  Product prod3 = prepo.findById(3).get(); 
//			  Product prod4 = prepo.findById(4).get();
			  
			  
			
			/*
			 * Part p1 = new Part (prod1, 4); partrepo.save(p1); Part p2 = new Part (prod2,
			 * 1); partrepo.save(p2); Part p3 = new Part (prod3, 2); partrepo.save(p3); Part
			 * p4 = new Part (prod4, 1); partrepo.save(p4);
			 */
//			 
			 
			  
			  
			  
			
			
//			  Part p1 = partrepo.findById(1).get(); Part p2 = partrepo.findById(2).get();
//			  Part p3 = partrepo.findById(3).get(); Part p4 = partrepo.findById(4).get();
			  
			  
			/*
			 * Fixset fixset1 = new Fixset(); fixset1.getPart().add(p1);
			 * fixset1.getPart().add(p2); fixset1.setFixsetName("Car Retyre");
			 * fixset1.setFixsetDescription("retyre car"); fixrepo.save(fixset1);
			 * 
			 * 
			 * Fixset fixset2 = new Fixset(); fixset2.getPart().add(p3);
			 * fixset2.getPart().add(p4); fixset2.setFixsetName("Motor Maintenance");
			 * fixset2.setFixsetDescription("check and maintain motor");
			 * 
			 * fixrepo.save(fixset2);
			 * 
			 * 
			 * Fixset fixset3 = new Fixset(); fixset3.getPart().add(p1);
			 * fixset3.getPart().add(p3); fixset3.setFixsetName("Car Maintenance");
			 * fixset3.setFixsetDescription("check and maintain car");
			 * 
			 * fixrepo.save(fixset3);
			 */
			 
			 
			 

		};
	}
}
