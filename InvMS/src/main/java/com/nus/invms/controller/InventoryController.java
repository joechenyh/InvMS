
package com.nus.invms.controller;

import java.util.ArrayList;

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



@Controller
@RequestMapping("/inventory")
public class InventoryController {

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


	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("inventories", invservice.findAllInventories());
		return "inventories";
	}
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("inventory", new Inventory());
		ArrayList<Product> plist = pservice.findAllProducts();
		model.addAttribute("products",plist);
		ArrayList<Supplier> slist = supservice.listAllSuppliers();
		model.addAttribute("suppliers",slist);
		return "inventory-form";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("inventory", invservice.getInventory(id));
		ArrayList<Product> plist = pservice.findAllProducts();
		model.addAttribute("products",plist);
		return "editInventory";
	}
	
	
	@RequestMapping(value = "/save")
	public String saveInventory(@ModelAttribute("inventory") @Valid Inventory inventory, 
		BindingResult bindingResult,  Model model) {
		String msg = checkError(inventory);
		
		if (bindingResult.hasErrors()|| msg!=null) 
		{
			model.addAttribute("message",msg);
			ArrayList<Product> plist = pservice.findAllProducts();
			model.addAttribute("products",plist);
			//model.addAttribute("inventory", new Inventory());
			System.out.println("!!!" + msg);
			return "inventory-form";
		}
		else 
		{
			int pdtPartNum = inventory.getProduct().getPartNumber();
			int supId = inventory.getSupplier().getSupplierId();
			Product product = pservice.findProductById(pdtPartNum);
			inventory.setItemName(product.getProductName());
			Supplier supplier = supservice.findById(supId);
			inventory.setSupplierName(supplier.getSupplierName());
			invservice.addInventory(inventory);
			return "forward:/inventory/list";
		}
		
		
	}
	
	
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteFacility(@PathVariable("id") Integer id) {
		invservice.deactivateInventory(invservice.getInventory(id));
		return "forward:/inventory/list";
	}
	
	@RequestMapping(value = "/getProduct/{id}")
	@ResponseBody
	public ArrayList<String> getProductById(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("inventory", new Inventory());
		Product result = pservice.findProductById(id);
		ArrayList<String> productInfo = new ArrayList<String>();
		productInfo.add(result.getUnitPrice().toString());
		//System.out.println(productInfo.get(0));
		//System.out.println("!!!"+result.getPartNumber());
		String partNum = String.valueOf(result.getPartNumber());
		productInfo.add(partNum);
		//System.out.println(productInfo.get(1));
		return productInfo;
	}
	
	public String checkError(Inventory inventory) {
		String msg = null;
		if(inventory.getBrandId()<0||inventory.getOriginalPrice()<0||inventory.getPartnerPrice()<0||inventory.getRetailPrice()<0||inventory.getWholesalePrice()<0||inventory.getUnits()<0) 
		{
			msg="Negative value unacceptable";
		}
		return msg;
	}
	
	@RequestMapping(value = "/getSupplier/{id}")
	@ResponseBody
	public ArrayList<String> getSupplierById(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("inventory", new Inventory());
		Supplier result = supservice.findById(id);
		ArrayList<String> supplierInfo = new ArrayList<String>();
		String supId = String.valueOf(result.getSupplierId());
		supplierInfo.add(supId);
		//System.out.println(productInfo.get(0));
		//System.out.println("!!!"+result.getPartNumber());
		//String partNum = String.valueOf(result.getPartNumber());
		//supplierInfo.add(result.getSupplierName().toString());
		//System.out.println(productInfo.get(1));
		return supplierInfo;
	}
}

