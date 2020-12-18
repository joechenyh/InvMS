package com.nus.invms;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
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
	
	//test
	
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
			System.out.println("Let's start to see our models! ");
			
			/*		Employee e1 = new Employee(); 
			
			Inventory i1 = new Inventory();
			
			Order o1 = new Order();
			
			PartUsage pu1 = new PartUsage();
			
			Supplier s1 = new Supplier();
			
			Product p1 = new Product();
			
			
			erepo.save(e1);
			irepo.save(i1);
			orepo.save(o1);
			purepo.save(pu1);
			srepo.save(s1);
			prepo.save(p1); */
		

};
	} 
}
