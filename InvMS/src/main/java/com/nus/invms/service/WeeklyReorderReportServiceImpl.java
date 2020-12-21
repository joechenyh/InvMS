package com.nus.invms.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nus.invms.repo.InventoryRepository;
import com.nus.invms.repo.OrderRepository;

@Service
public class WeeklyReorderReportServiceImpl implements WeeklyReorderReportService {

	@Autowired
	InventoryRepository irepo; 
	
	public void GenerateDATFile() throws FileNotFoundException {
		OutputStream out1;

			out1 = new FileOutputStream("C:\\Temp\\DATfile.dat");

		
	
		
		//foreach Supplier
		
		//pullinventory 
		
		
		String stringtowriteheader="Inventory Reorder Report for products from Supplier \r\n" + 
				"------------------------------------------------------\r\n" + 
				"===================================================================\r\n" + 
				"Part No. Unit.Price Qty Reorder Qty. Min.Ord.Qty Ord.Qty Price\r\n" + 
				"===================================================================";
		
		String stringtowrite = stringtowriteheader;
        byte b[]=stringtowrite.getBytes();//converting string into byte array    
        
        try
        {
        	System.out.println("Inside try block");
        	out1.write(b);
        }
        catch(Exception e)
        { 
            System.out.println("Exception caught in catch block"); 
        } 
        finally
        {
        	System.out.println("finally block executed");
        }
       
		
		
		// after loop through all suppliers 
		
		try {
			out1.close();
			System.out.println("SUCCESS GENERATING DAT FILE!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}