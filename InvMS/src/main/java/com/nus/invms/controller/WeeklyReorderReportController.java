
package com.nus.invms.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.*;  

import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.Supplier;
import com.nus.invms.service.EmployeeInterface;
import com.nus.invms.service.InventoryService;
import com.nus.invms.service.InventoryServiceImpl;
import com.nus.invms.service.PartUsageService;
import com.nus.invms.service.PartUsageServiceImpl;
import com.nus.invms.service.ProductService;
import com.nus.invms.service.ProductServiceImpl;
import com.nus.invms.service.SupplierInterface;
import com.nus.invms.service.WeeklyReorderReportService;



@Controller
@RequestMapping("/weeklyreport")
public class WeeklyReorderReportController {

	@Autowired
	private WeeklyReorderReportService wrrservice;
	
	@Autowired
	public void setWRRService(WeeklyReorderReportService wrrserviceimpl) {
		this.wrrservice = wrrserviceimpl;
	}
	
	@Autowired
	private InventoryService invservice;
	
	@Autowired
	private PartUsageService puservice;
	
	@Autowired 
	EmployeeInterface empservice;
	
	@Autowired
	private SupplierInterface supservice;
	
	//@Autowired
	//private EmployeeService eservice; 

	@Autowired
	public void setInvService(InventoryServiceImpl invserviceimpl) {
		this.invservice = invserviceimpl;
	}
	
	@Autowired
	public void setPUService(PartUsageServiceImpl puserviceimpl) {
		this.puservice = puserviceimpl;
	}
	
	@Autowired
	private ProductService pservice;
	
	@Autowired
	public void setProductService(ProductServiceImpl pserviceImpl) {
		this.pservice = pserviceImpl;
	}
	
	@Autowired
	public void setSupplierService(SupplierInterface supserviceImpl) {
		this.supservice = supserviceImpl;
	}
	
	
/*	//1. Manage Inventory
	@RequestMapping(value = "/inventorydashboard")
	public String Viewdashboard(){
		return "inventorydashboard";
	}*/


	@RequestMapping(value = "/print")
	public String PrintDATFile() throws FileNotFoundException {
		try{
			wrrservice.GenerateDATFile();
		}
		catch(Exception e) {
			return "error";
		}
		
			return "printsuccess";
		
		
	}
}