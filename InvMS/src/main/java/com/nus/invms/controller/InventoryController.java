package com.nus.invms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.PartUsage;
import com.nus.invms.service.InventoryServiceImpl;
import com.nus.invms.service.PartUsageServiceImpl;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryServiceImpl invservice;
	
	@Autowired
	private PartUsageServiceImpl puservice;
	
	//@Autowired
	//private EmployeeService eservice; 

	@Autowired
	public void setInvService(InventoryServiceImpl invservice) {
		this.invservice = invservice;
	}
	
	//1. Manage Inventory
	@RequestMapping(value = "/inventorydashboard")
	public String Viewdashboard(){
		return "inventorydashboard";
	}
	
	//2. Create Inventory
	@RequestMapping(value = "/createinv")
	public String addUsage(Model model) {
		model.addAttribute("inventory", new Inventory());
	//	ArrayList<String> flist = fservice.findAllPartNames(); need a service to show all available part numbers 
	//	model.addAttribute("fnames", flist);
		return "inventory-form";
	}
	
	//3. Update Inventory
	@RequestMapping(value = "/editinv")
	public String addUsage(Model model) {
		model.addAttribute("inventory", new Inventory());
	//	ArrayList<String> flist = fservice.findAllPartNames(); need a service to show all available part numbers 
	//	model.addAttribute("fnames", flist);
		return "inventory-form";
	}
	
	//4. Check Inventory 
	@RequestMapping(value = "/viewinv")
	public String addUsage(Model model) {
		model.addAttribute("inventory", new Inventory());
	//	ArrayList<String> flist = fservice.findAllPartNames(); need a service to show all available part numbers 
	//	model.addAttribute("fnames", flist);
		return "inventory-form";
	}
	
	//5. Deactivate Inventory 
	@RequestMapping(value = "/deleteinv")
	public String addUsage(Model model) {
		model.addAttribute("inventory", new Inventory());
	//	ArrayList<String> flist = fservice.findAllPartNames(); need a service to show all available part numbers 
	//	model.addAttribute("fnames", flist);
		return "inventory-form";
	}
	
	//6. Search/List Inventory 
	@RequestMapping(value = "/searchinv")
	public String addUsage(Model model) {
		model.addAttribute("inventory", new Inventory());
	//	ArrayList<String> flist = fservice.findAllPartNames(); need a service to show all available part numbers 
	//	model.addAttribute("fnames", flist);
		return "inventory-form";
	}
	
	
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("inventories", invservice.listInventory());
		return "inventories";
	}
	

}
