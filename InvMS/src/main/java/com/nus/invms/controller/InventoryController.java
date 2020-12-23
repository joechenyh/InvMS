
package com.nus.invms.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
	

	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("inventories", invservice.findAllInventories());
		ArrayList<Product> pList = new ArrayList<Product>();
		ArrayList<Product> pList2 = new ArrayList<Product>();
		pList = (ArrayList<Product>) pservice.findAllProducts();
		for (Iterator<Product> iterator = pList.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if(product.getStatus().toString()=="ACTIVE") {
				System.out.println("!!!!" + product);
				pList2.add(product);
			}
			
		}
		return "inventories";
	}
	

	
	@GetMapping("/search")
	public String listPage(Model model, @Param("keyword") String keyword) {
		return searchList(model, 1, keyword);
	}
	
	@GetMapping("/search/page/{pageNumber}")
	public String searchList(Model model, @PathVariable("pageNumber") int currentPage, @Param("keyword") String keyword) {
		

		Page<Inventory> page = invservice.searchInventory(currentPage, keyword);
		long totalElements = page.getTotalElements();
		int totalPages = page.getTotalPages();
		

		List<Inventory> invList = page.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("invList", invList);
		model.addAttribute("keyword", keyword);

		return "searchinventories";
	}
	

	
	
	@RequestMapping(value = "/add")
	public String addForm(Model model) 
	{
		model.addAttribute("inventory", new Inventory());
		ArrayList<Product> pList = new ArrayList<Product>();
		ArrayList<Product> pList2 = new ArrayList<Product>();
		pList = (ArrayList<Product>) pservice.findAllProducts();
		for (Iterator<Product> iterator = pList.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if(product.getStatus().toString()=="ACTIVE") {
				System.out.println("!!!!" + product);
				pList2.add(product);
			}
			
		}
		model.addAttribute("products",pList2);
		ArrayList<Supplier> sList = new ArrayList<Supplier>();
		ArrayList<Supplier> sList2 = new ArrayList<Supplier>();
		sList = (ArrayList<Supplier>) supservice.listAllSuppliers();
		System.out.println("!!!!" + "supplier");
		for (Iterator<Supplier> iterator = sList.iterator(); iterator.hasNext();) 
		{
			Supplier supplier = iterator.next();
			if(supplier.getStatus().toString()=="ACTIVE") 
			{
				System.out.println("!!!!" + supplier);
				sList2.add(supplier);
			}
			model.addAttribute("suppliers",sList2);
			
		}
		return "inventory-form";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("inventory", invservice.getInventory(id));
		ArrayList<Product> pList = new ArrayList<Product>();
		ArrayList<Product> pList2 = new ArrayList<Product>();
		pList = (ArrayList<Product>) pservice.findAllProducts();
		for (Iterator<Product> iterator = pList.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if(product.getStatus().toString()=="ACTIVE") {
				System.out.println("!!!!" + product);
				pList2.add(product);
			}
			
		}
		model.addAttribute("products",pList2);
		ArrayList<Supplier> slist = supservice.listAllSuppliers();
		model.addAttribute("suppliers",slist);
		return "editInventory";
	}
	
	
	@RequestMapping(value = "/save")
	public String saveInventory(@ModelAttribute("inventory") @Valid Inventory inventory, 
		BindingResult bindingResult,  Model model) {
		
		String msg;
		

		if (bindingResult.hasErrors()) 
			 
		{
			ArrayList<Product> plist = pservice.findAllProducts();
			model.addAttribute("products",plist);
			model.addAttribute("inventory", inventory);
			ArrayList<Product> pList = new ArrayList<Product>();
			ArrayList<Product> pList2 = new ArrayList<Product>();
			pList = (ArrayList<Product>) pservice.findAllProducts();
			for (Iterator<Product> iterator = pList.iterator(); iterator.hasNext();) {
				Product product = iterator.next();
				if(product.getStatus().toString()=="ACTIVE") {
					System.out.println("!!!!" + product);
					pList2.add(product);
				}
				
			}
			model.addAttribute("products",pList2);
			ArrayList<Supplier> sList = new ArrayList<Supplier>();
			ArrayList<Supplier> sList2 = new ArrayList<Supplier>();
			sList = (ArrayList<Supplier>) supservice.listAllSuppliers();
			System.out.println("!!!!" + "supplier");
			for (Iterator<Supplier> iterator = sList.iterator(); iterator.hasNext();) 
			{
				Supplier supplier = iterator.next();
				if(supplier.getStatus().toString()=="ACTIVE") 
				{
					System.out.println("!!!!" + supplier);
					sList2.add(supplier);
				}
				model.addAttribute("suppliers",sList2);
			}
			
			return "inventory-form";
		}
		else 
		{
			ArrayList<Inventory> iList = new ArrayList<Inventory>();
			iList = (ArrayList<Inventory>) invservice.findAllInventories();
			for (Iterator<Inventory> iterator = iList.iterator(); iterator.hasNext();) {
				Inventory inventory2 = iterator.next();
				if (inventory2.getProduct().getPartNumber()==inventory.getProduct().getPartNumber()) {
					ArrayList<Product> plist = pservice.findAllProducts();
					model.addAttribute("products",plist);
					model.addAttribute("inventory", inventory);
					ArrayList<Product> pList = new ArrayList<Product>();
					ArrayList<Product> pList2 = new ArrayList<Product>();
					pList = (ArrayList<Product>) pservice.findAllProducts();
					for (Iterator<Product> iterator1 = pList.iterator(); iterator1.hasNext();) {
						Product product = iterator1.next();
						if(product.getStatus().toString()=="ACTIVE") {
							System.out.println("!!!!" + product);
							pList2.add(product);
						}
						
					}
					model.addAttribute("products",pList2);
					ArrayList<Supplier> sList = new ArrayList<Supplier>();
					ArrayList<Supplier> sList2 = new ArrayList<Supplier>();
					sList = (ArrayList<Supplier>) supservice.listAllSuppliers();
					System.out.println("!!!!" + "supplier");
					for (Iterator<Supplier> iterator2 = sList.iterator(); iterator2.hasNext();) 
					{
						Supplier supplier = iterator2.next();
						if(supplier.getStatus().toString()=="ACTIVE") 
						{
							System.out.println("!!!!" + supplier);
							sList2.add(supplier);
						}
						model.addAttribute("suppliers",sList2);
						
					}
					msg = "Duplicate Part Number";
					model.addAttribute("message",msg);
					return "inventory-form";
				}
				
			}
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
	public ArrayList<String> getProductById(@PathVariable("id") String keyword, Model model) {
		model.addAttribute("inventory", new Inventory());
		Product result = pservice.findProductByName(keyword);
		ArrayList<String> productInfo = new ArrayList<String>();
		productInfo.add(result.getUnitPrice().toString());
		String partNum = String.valueOf(result.getPartNumber());
		productInfo.add(partNum);
		return productInfo;
	}
	
	public String checkError(Inventory inventory) {
		String msg = null;
		if (inventory.getOriginalPrice()!=null||inventory.getPartnerPrice()!=null||inventory.getRetailPrice()!=null||inventory.getWholesalePrice()!=null) {
			if(inventory.getOriginalPrice()<0||inventory.getPartnerPrice()<0||inventory.getRetailPrice()<0||inventory.getWholesalePrice()<0||inventory.getUnits()<0) 
			{
				msg="Negative value unacceptable";
			}
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
		return supplierInfo;
	}
	
	@RequestMapping(value = "/confirmedit")
	public String confirmEditInventory(@ModelAttribute("inventory") @Valid Inventory inventory, 
		BindingResult bindingResult,  Model model) {
		
		String msg;
		

		if (bindingResult.hasErrors()) 
			 
		{	
			ArrayList<Product> plist = pservice.findAllProducts();
			model.addAttribute("products",plist);
			model.addAttribute("inventory", inventory);
			ArrayList<Product> pList = new ArrayList<Product>();
			ArrayList<Product> pList2 = new ArrayList<Product>();
			pList = (ArrayList<Product>) pservice.findAllProducts();
			for (Iterator<Product> iterator = pList.iterator(); iterator.hasNext();) {
				Product product = iterator.next();
				if(product.getStatus().toString()=="ACTIVE") {
					System.out.println("!!!!" + product);
					pList2.add(product);
				}
				
			}
			model.addAttribute("products",pList2);
			ArrayList<Supplier> sList = new ArrayList<Supplier>();
			ArrayList<Supplier> sList2 = new ArrayList<Supplier>();
			sList = (ArrayList<Supplier>) supservice.listAllSuppliers();
			System.out.println("!!!!" + "supplier");
			for (Iterator<Supplier> iterator = sList.iterator(); iterator.hasNext();) 
			{
				Supplier supplier = iterator.next();
				if(supplier.getStatus().toString()=="ACTIVE") 
				{
					System.out.println("!!!!" + supplier);
					sList2.add(supplier);
				}
				model.addAttribute("suppliers",sList2);
			}
			
			return "editInventory";
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
}

