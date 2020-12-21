package com.nus.invms.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.Supplier;
import com.nus.invms.repo.InventoryRepository;
import com.nus.invms.repo.OrderRepository;
import com.nus.invms.repo.ProductRepository;
import com.nus.invms.repo.SupplierRepository;

@Service
public class WeeklyReorderReportServiceImpl implements WeeklyReorderReportService {

	@Autowired
	InventoryRepository irepo; 
	
	@Autowired
	SupplierRepository srepo;
	
	@Autowired
	ProductRepository prepo;
	
	
	public void GenerateDATFile() throws FileNotFoundException {
		OutputStream out1;

			out1 = new FileOutputStream("C:\\Temp\\DATfile.dat");
			
			String stringtowrite;
			
			List<Supplier> supplierlist = srepo.findAll();
			
			
			
			for (Supplier s : supplierlist) 
				
			{ 
				Double sum = 0.00;
				
				String stringtowriteheader="Inventory Reorder Report for products from Supplier/t:/t" + s.getSupplierName() +  " \r\n" + 
						"------------------------------------------------------\r\n" + 
						"===================================================================\r\n" + 
						"Part No. Unit.Price Qty Reorder Qty. Min.Ord.Qty Ord.Qty Price\r\n" + 
						"===================================================================\r\n";
				byte a[]=stringtowriteheader.getBytes();
				
				try {
					out1.write(a);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
		        List<Inventory> inventorylist = irepo.findInventoryBySupplier(s.getSupplierId());
		       
		        
		        for (Inventory i: inventorylist)
		        	
		        {
		        	Integer partnumber = i.getProduct().getPartNumber(); 
		        	Double unitprice = i.getOriginalPrice();
		        	Integer quantity = i.getUnits();
		        	
		        	Product product = prepo.findProductByPartNumber(partnumber);
		        	Integer reorderqty = product.getReorderLevel();
		        	Integer minorderqty = product.getMinReorderQty();
		        	Integer shortfall = reorderqty - quantity;
		        	Integer orderquantity = Math.max(minorderqty, shortfall);
		            Double price = orderquantity * unitprice;
		        	
		        	sum = sum + price;
		        
		        
		        		
		        stringtowrite = partnumber.toString() + "\t" + unitprice.toString() + "\t" + quantity.toString() + "\t" + reorderqty.toString() + "\t" + minorderqty.toString() + "\t" + orderquantity.toString() 
		        + "\t" + price.toString() + "\r\n" + "Total Amount =" + sum.toString() + "\r\n";
		        
		        
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
			}
			}
	
		
		//foreach Supplier
		
		//pullinventory 
		
		
		
       
		
		
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