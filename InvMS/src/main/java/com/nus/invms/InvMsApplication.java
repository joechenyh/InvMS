package com.nus.invms;


import java.time.LocalDate;

import javax.validation.constraints.PastOrPresent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nus.invms.domain.Employee;
import com.nus.invms.domain.Fixset;
import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.Order;
import com.nus.invms.domain.OrderStatus;
import com.nus.invms.domain.OrderType;
import com.nus.invms.domain.Part;
import com.nus.invms.domain.PartUsage;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.RoleType;
import com.nus.invms.domain.Status;
import com.nus.invms.domain.Supplier;
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

	//Java CA

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
			
			 Employee e1 = new Employee("Elo", "qwerty", "qwerty", Status.ACTIVE, RoleType.ADMIN);
			 Employee e2 = new Employee("Elmo", "asdfgh", "asdfgh", Status.INACTIVE, RoleType.MECHANIC);
			 erepo.save(e1);
			 erepo.save(e2);
			 
			 Supplier s1 = new Supplier("Nestle", Status.ACTIVE, "91134512", "Pasir Ris", "style@mail.com");
			 Supplier s2 = new Supplier("Gogo", Status.ACTIVE, "92323890", "Jurong", "se@mail.com");
			 srepo.save(s1);
			 srepo.save(s2);

			 Product prod1 = new Product (1001, 12, 12, "tyre", "car tyre", "black", "20cm", "dunlop", "bottom", 120.0, Status.ACTIVE);
			 Product prod2 = new Product (1002, 2, 2, "jockey tool", "jockey tool for car repair", "silver", "20cm", "mytool", "office", 20.0, Status.ACTIVE);
			 Product prod3 = new Product (1003, 5, 5, "grease", "car grease", "black", "1 litre", "greeeeease", "top", 12.50, Status.ACTIVE);
			 Product prod4 = new Product (1004, 1, 1,"motor engine", "motor engine replacement", "silver", "12kg", "engine centre", "middle", 70.0, Status.ACTIVE); 
			 prepo.save(prod1);
			 prepo.save(prod2);
			 prepo.save(prod3);
			 prepo.save(prod4);
			  
			 Part p1 = new Part (prod1, 4);
			 partrepo.save(p1);
			 Part p2 = new Part (prod2, 1);
			 partrepo.save(p2);
			 Part p3 = new Part (prod3, 2);
			 partrepo.save(p3);
			 Part p4 = new Part (prod4, 1);
			 partrepo.save(p4);
			  
			 Fixset fixset1 = new Fixset();
			 fixset1.getPart().add(p1);
			 fixset1.getPart().add(p2);
			 fixset1.setFixsetName("Car Retyre");
			 fixset1.setFixsetDescription("retyre car");
			 fixrepo.save(fixset1);
			              
			              
			 Fixset fixset2 = new Fixset();
			 fixset2.getPart().add(p3);
			 fixset2.getPart().add(p4);
			 fixset2.setFixsetName("Motor Maintenance");
			 fixset2.setFixsetDescription("check and maintain motor");
			              
			 fixrepo.save(fixset2);
			              
			              
			 Fixset fixset3 = new Fixset(); fixset3.getPart().add(p1);
			 fixset3.getPart().add(p3);
			 fixset3.setFixsetName("Car Maintenance");
			 fixset3.setFixsetDescription("check and maintain car");
			              
			 fixrepo.save(fixset3);
			 
			
			 Product prod5 = new Product (1005, 12, 12, "SB Nike", "Sports Shoe", "black", "Huge", "Alibaba", "bottom", 20.0, Status.ACTIVE);
			 Inventory i1 = new Inventory("Nike", "Small", "Shoe", "Sports", "Sports Shoe", 99.00, 200.00, 300.00, 50.00, "SB Nike", 100, prod5,s1, "Nestle");
			 prepo.save(prod5);
			 irepo.save(i1);
			 Product prod6 = new Product (1006, 20, 100, "Cyclo", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Inventory i2 = new Inventory("Toyota", "Hard", "Accessory", "Hardware", "Gears", 50.00, 250.00, 370.00, 51.00, "Cyclo", 100, prod6,s2, "Gogo");
			 prepo.save(prod6);
			 irepo.save(i2);
			 
			 Product prod7 = new Product (1007, 20, 100, "Typhone", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod8 = new Product (1008, 20, 100, "Tsunami", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod9 = new Product (1009, 20, 100, "Quaker", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod10 = new Product (1010, 20, 100, "Shaker", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod11 = new Product (1011, 20, 100, "Fragrance", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod12 = new Product (1012, 20, 100, "Washer", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod13 = new Product (1013, 20, 100, "Wiper", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod14 = new Product (1014, 20, 100, "Summer tyres", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod15 = new Product (1015, 20, 100, "Winter tyres", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod16 = new Product (1016, 20, 100, "Spring tyres", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod17 = new Product (1017, 20, 100, "Autumn tyres", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod18 = new Product (1018, 20, 100, "Snow tyres", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod19 = new Product (1019, 20, 100, "Monster truck tyres", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 Product prod20 = new Product (1020, 20, 100, "Multi-thread tyres", "Car gear", "oily", "Small", "Emart", "bottom", 20.0, Status.ACTIVE);
			 prepo.save(prod7);
			 prepo.save(prod8);
			 prepo.save(prod9);
			 prepo.save(prod10);
			 prepo.save(prod11);
			 prepo.save(prod12);
			 prepo.save(prod13);
			 prepo.save(prod14);
			 prepo.save(prod15);
			 prepo.save(prod16);
			 prepo.save(prod17);
			 prepo.save(prod18);
			 prepo.save(prod19);
			 prepo.save(prod20);
			 
//			 (String brandName, String invdescription, String invtype, String category, String subCategory, Double originalPrice, Double wholesalePrice, Double retailPrice, Double partnerPrice, String itemName, int units, Product product, Supplier supplier, String supplierName)
				Inventory i3 = new Inventory("Singa Brand", "Windows with special coating A", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "tyre", 35, prod1, s1, "Nestle");
				irepo.save(i3);
				Inventory i4 = new Inventory("Coco Brand", "Windows with special coating B", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "jockey tool", 35, prod2, s1, "Gogo");
				irepo.save(i4);
				Inventory i5 = new Inventory("Alan Brand", "Windows with special coating C", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "grease", 35, prod3, s1, "Nestle");
				irepo.save(i5);
				Inventory i6 = new Inventory("Taka Brand", "Windows with invisible coating ", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "motor engine", 35, prod4, s1, "Nestle");
				irepo.save(i6);
				Inventory i7 = new Inventory("Lee Brand", "Windows with solar coating", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Quaker", 35, prod9, s1, "Nestle");
				irepo.save(i7);
				Inventory i8 = new Inventory("Rocky Brand", "Windows with reflective coating", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Shaker", 35, prod10, s1, "Nestle");
				irepo.save(i8);
				Inventory i9 = new Inventory("Metal Brand", "Windows with hydrophobic coating", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Typhone", 35, prod7, s1, "Nestle");
				irepo.save(i9);
				Inventory i10 = new Inventory("Caterpillar Brand", "Windows with hydrophilic coating", "Car Windows", "Front Windows", "Unbreakable Windows", 23.00, 35.00, 47.00, 96.00, "Tsunami", 35, prod8, s1, "Nestle");
				irepo.save(i10);
				Inventory i11 = new Inventory("Random Brand", "Tyres for Rainy Days", "Car Parts", "Tyres", "Tyre A", 23.00, 35.00, 47.00, 96.00, "Fragrance", 35, prod11, s1, "Gogo");
				irepo.save(i11);
				Inventory i12 = new Inventory("King Brand", "Tyres for dry Days", "Car Parts", "Tyres", "Tyre A", 23.00, 35.00, 47.00, 96.00, "Washer", 35, prod12, s1, "Gogo");
				irepo.save(i12);
				Inventory i13 = new Inventory("Singa Brand", "Tyres for hot climates", "Car Parts", "Tyres", "Tyre B", 23.00, 35.00, 47.00, 96.00, "Wiper", 35, prod13, s1, "Gogo");
				irepo.save(i13);
				Inventory i14 = new Inventory("Coco Brand", "Tyres for humid climates", "Car Parts", "Tyres", "Tyre C", 23.00, 35.00, 47.00, 96.00, "Summer tyres", 35, prod14, s1, "Gogo");
				irepo.save(i14);
				Inventory i15 = new Inventory("Alan Brand", "Tyres for winter season", "Car Parts", "Tyres", "Tyre C", 23.00, 35.00, 47.00, 96.00, "Winter tyres", 35, prod15, s1, "Gogo");
				irepo.save(i15);
				Inventory i16 = new Inventory("Taka Brand", "Tyres for wet Days", "Car Parts", "Tyres", "Tyre C", 23.00, 35.00, 47.00, 96.00, "Spring tyres", 35, prod16, s1, "Gogo");
				irepo.save(i16);
				Inventory i17 = new Inventory("Lee Brand", "Tyres for cobbled streets", "Car Parts", "Tyres", "Tyre C", 23.00, 35.00, 47.00, 96.00, "Autumn tyres", 35, prod17, s1, "Gogo");
				irepo.save(i17);
				Inventory i18 = new Inventory("Rocky Brand", "Tyres for black ice", "Car Parts", "Tyres", "Tyre C", 23.00, 35.00, 47.00, 96.00, "Snow tyres", 35, prod18, s1, "Gogo");
				irepo.save(i18);
				Inventory i19 = new Inventory("Metal Brand", "Tyres for monster trucks", "Car Parts", "Tyres", "Tyre D", 23.00, 35.00, 47.00, 96.00, "Monster truck tyres", 35, prod19, s1, "Gogo");
				irepo.save(i19);
				Inventory i20 = new Inventory("Caterpillar Brand", "Tyres for construction trucks", "Car Parts", "Tyres", "Tyre D", 23.00, 35.00, 47.00, 96.00, "Multi-thread tyres", 35, prod20, s1, "Gogo");
				irepo.save(i20);
			 
			 LocalDate startDate = LocalDate.of(2020, 12, 6);
			
			 Order o1 = new Order(startDate, null, 100, 0, OrderStatus.OrderNotYetReceived, OrderType.ORDER, e1, s1, prod3, 101);
			 LocalDate startDate1 = LocalDate.of(2020, 12, 17);
			 
			 Order o2 = new Order(startDate1, null, 250, 0, OrderStatus.OrderNotYetReceived, OrderType.ORDER, e2, s1, prod2, 102);
			 
			 LocalDate startDate2 = LocalDate.of(2020, 12, 20);
			 
			 Order o3 = new Order(startDate2, null, 10, 10, OrderStatus.NotYetReturned, OrderType.RETURN, e1, s2, prod1, 103);
			 orepo.save(o1);
			 orepo.save(o2);
			 orepo.save(o3);
			 
			
			 
			 PartUsage pu1 = new PartUsage(e1, prod5, 5, startDate2, "SHA1234Z");
			 PartUsage pu2 = new PartUsage(e2, prod6, 5, startDate1, "SHA1234Z");
			 purepo.save(pu1);
			 purepo.save(pu2);

		};
	}
}


