package com.nus.invms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.Employee;
import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.PartUsage;
import com.nus.invms.domain.Product;
import com.nus.invms.service.EmployeeImplementation;
import com.nus.invms.service.EmployeeInterface;
import com.nus.invms.service.InventoryService;
import com.nus.invms.service.InventoryServiceImpl;
import com.nus.invms.service.NotificationService;
import com.nus.invms.service.PartUsageService;
import com.nus.invms.service.PartUsageServiceImpl;
import com.nus.invms.service.ProductService;
import com.nus.invms.service.ProductServiceImpl;

@Controller
@RequestMapping("/partusage")
public class PartUsageController {

	@Autowired
	private InventoryService invservice;

	@Autowired
	private PartUsageService puservice;

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
	public void setProdService(ProductServiceImpl pserviceimpl) {
		this.pservice = pserviceimpl;
	}

	@Autowired
	private EmployeeInterface empservice;

	@Autowired
	public void setEmpService(EmployeeImplementation empserviceimpl) {
		this.empservice = empserviceimpl;
	}
	
	@Autowired
	NotificationService nservice;

	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("usages", puservice.listPartUsage());
		return "usages";
	}

//	!!!For Transaction history function!!!
	@GetMapping("/partnumberfilter")
	public String ListPartNumber(Model model, @Param("pnumber") Integer pnumber) {
		List<PartUsage> usages = puservice.findPartUsageByPartNumber(pnumber);
		model.addAttribute("usages", usages);
		model.addAttribute("pnumber", pnumber);
		return "usageByPartNumber";
	}


	@GetMapping("/datefilter")
	public String ListByDate(Model model, @Param("fromDate") String fromDate, @Param("toDate") String toDate) {
		List<PartUsage> usages = puservice.findByUsagedateBetween(fromDate, toDate);
		model.addAttribute("usages", usages);
		model.addAttribute("fromDate", fromDate);
		model.addAttribute("toDate", toDate);
		return "usageByDate";
	}
	
	
	@GetMapping("/usagereport")
	public String report(Model model, @Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("pnumber") Integer pnumber) {
		List<PartUsage> report = puservice.findByDateAndPartNumber(fromDate, toDate, pnumber);
		model.addAttribute("report", report);
		model.addAttribute("fromDate", fromDate);
		model.addAttribute("toDate", toDate);
		model.addAttribute("pnumber", pnumber);
		return "usagereport";
	}
	
	
	@RequestMapping(value = "/add")
	public String addForm(Model model) {
		model.addAttribute("usage", new PartUsage());
		ArrayList<Product> plist = pservice.findAllProducts();
		model.addAttribute("products", plist);
		ArrayList<Employee> elist = empservice.listAllEmployees();
		model.addAttribute("employees", elist);
		return "usage-form";
	}

	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("usage", puservice.findByTransactionId(id));
		return "usage-form";
	}

	@RequestMapping(value = "/save")
	public String saveusage(@ModelAttribute("usage") @Valid PartUsage usage, BindingResult bindingResult, Model model) {
		String msg = checkError(usage);

		if(bindingResult.hasErrors()) {
			return "usage-form";
		}

		int pdtPartNum = usage.getProduct().getPartNumber();
		Product product = pservice.findProductById(pdtPartNum);
		usage.setProduct(product);

		int empId = usage.getEmployee().getID();
		Employee employee = empservice.findById(empId);
		usage.setEmployee(employee);
		
		int reorderLvl = product.getReorderLevel();
		int quantity = usage.getQuantity();
		Inventory inventory = invservice.findInventoryByPartNumber(pdtPartNum);


		
		if (bindingResult.hasErrors() || msg != null||inventory.getUnits()<quantity) {
			model.addAttribute("message", msg);
			ArrayList<Employee> elist = empservice.listAllEmployees();
			model.addAttribute("employees", elist);
			System.out.println("!!!" + msg);
			return "usage-form";
		} else {
			
			if(inventory.getUnits()>quantity||inventory.getUnits()==quantity) {
				int newQuantity = inventory.getUnits() - quantity;
				if(newQuantity==0) 
				{
					invservice.deactivateInventory(inventory);
					String mail = "Product " + product.getProductName() + " Part Number: " + product.getPartNumber() + " has reach 0. This product will be removed from the inventory list.";
					nservice.sendNotification(mail);
				}
				else 
				{
		
					if(newQuantity<reorderLvl) {
						String mail = "Product " + product.getProductName() + " Part Number: " + product.getPartNumber() + " has reach below reorder level. Time to replenish.";
						nservice.sendNotification(mail);
					}
					inventory.setUnits(newQuantity);
					invservice.updateInventory(inventory);
				}
			}

			puservice.addPartUsage(usage);
			return "forward:/partusage/list";
		}
	}

	@RequestMapping(value = "/delete/{id}")
	public String deletePartUsage(@PathVariable("id") Integer id) {
		puservice.deletePartUsage(puservice.findByTransactionId(id));
		return "forward:/partusage/list";
	}

	public String checkError(PartUsage partusage) {
		String msg = null;
		if (partusage.getQuantity() < 0) {
			msg = "Negative value unacceptable";
		}
		return msg;
	}

}
