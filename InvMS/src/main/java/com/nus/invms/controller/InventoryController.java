package com.nus.invms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.PartUsage;
import com.nus.invms.service.EmployeeInterface;
import com.nus.invms.service.InventoryService;
import com.nus.invms.service.InventoryServiceImpl;
import com.nus.invms.service.PartUsageService;
import com.nus.invms.service.PartUsageServiceImpl;



@Controller
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService invservice;
	
	@Autowired
	private PartUsageService puservice;
	
	@Autowired 
	EmployeeInterface empservice;
	
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
	
	//1. Manage Inventory
	@RequestMapping(value = "/inventorydashboard")
	public String Viewdashboard(){
		return "inventorydashboard";
	}


	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("inventories", invservice.listInventory());
		return "inventories";
	}
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("inventory", new Inventory());
		return "inventory-form";
	}
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("inventory", invservice.getInventory(id));
		return "inventory-form";
	}
	@RequestMapping(value = "/save")
	public String saveInventory(@ModelAttribute("inventory") @Valid Inventory inventory, 
			BindingResult bindingResult,  Model model) {
		if (bindingResult.hasErrors()) {
			return "inventory-form";
		}
		invservice.addInventory(inventory);
		return "forward:/inventory/list";
	}
	@RequestMapping(value = "/delete/{id}")
	public String deleteFacility(@PathVariable("id") Integer id) {
		invservice.deactivateInventory(invservice.getInventory(id));
		return "forward:/inventory/list";
	}
	
	
	
	
	

}
