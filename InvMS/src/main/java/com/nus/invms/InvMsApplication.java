package com.nus.invms;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.PartUsage;
import com.nus.invms.domain.Usage;


@SpringBootApplication
public class InvMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvMsApplication.class, args);
		
		Inventory inventory1 = new Inventory("JoeJoe Supplier", 1, "JoeJoe Brand", "Special Rocket Tyre", "Helps your car to fly",
				"Tyre", "Cars", "Car Parts", 24.00, 27.00,
				30.00, 28.00, 3);
		
		LocalDate date = LocalDate.now();

		
		PartUsage usage1 = new PartUsage(1, 999, 3, date, "SDM8145A");
		
		
		
		
	}

}
