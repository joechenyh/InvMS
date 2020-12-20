package com.nus.invms.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.Employee;
import com.nus.invms.domain.Inventory;
import com.nus.invms.domain.Order;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.RoleType;
import com.nus.invms.domain.Supplier;
import com.nus.invms.service.EmployeeInterface;
import com.nus.invms.service.InventoryService;
import com.nus.invms.service.InventoryServiceImpl;
import com.nus.invms.service.OrderInterface;
import com.nus.invms.service.ProductService;
import com.nus.invms.service.ProductServiceImpl;
import com.nus.invms.service.SupplierImplementation;
import com.nus.invms.service.SupplierInterface;




@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderInterface oservice;
	
	@Autowired 
	EmployeeInterface empservice;
	
	@Autowired
	InventoryService iservice;
	
	@Autowired
	ProductService pdtservice;
	
	@Autowired
	SupplierInterface supservice;
	
	@Autowired
	public void setIface(SupplierImplementation siserviceimpl) {
		this.supservice = siserviceimpl;
	}
	
	@Autowired
	public void setInvService(InventoryServiceImpl invserviceimpl) {
		this.iservice = invserviceimpl;
	}
	
	@Autowired
	public void setPdtService(ProductServiceImpl pdtserviceimpl) {
		this.pdtservice = pdtserviceimpl;
	}
	
	@RequestMapping(value = "/add")
	public String add(Model model, HttpSession session) 
	{
		model.addAttribute("order", new Order());
		ArrayList<Product> plist = pdtservice.findAllProducts();
		model.addAttribute("products",plist);
		ArrayList<Supplier> slist = supservice.listAllSuppliers();
		model.addAttribute("suppliers",slist);
		return "order-form";
	}
	
	
	
	@RequestMapping(value = "/save")
	public String saveOrder(@ModelAttribute("order") @Valid Order order, 
			BindingResult bindingResult,  Model model, Errors errors, HttpSession session) 
	{
		
		Employee emp = (Employee) session.getAttribute("empsession");
		if (order.getEmployee().getID() != emp.getID())
		{
			if (emp.getRole() != RoleType.ADMIN)
			{
				errors.rejectValue("employee.ID", "not right", "You do not have the right to input for other employee");
			}
			else
			{
				boolean testing = false;
				ArrayList<Employee> employees = empservice.listAllEmployees();
				for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
					Employee employee1 = (Employee) iterator.next();
					if (employee1.getID() == (order.getEmployee().getID())) {
				    	testing = true;
				    }
				}
				
				if (!testing){
					errors.rejectValue("employee.ID", "invalid Id", "Id cannot be found in system");
				}
			}
		}
		
		if (order.getDateReceivedReturned() != null) {
			if (order.getDateReceivedReturned().isBefore(order.getOrderDate()))
			{
				errors.rejectValue("dateReceived", "invalid date", "Please select receive date same as or later than order date");
			}
		}
		
		if (bindingResult.hasErrors()) {
			return "order-form";
		}
		else {
			if(order.getStatus().toString()=="OrderReceived") 
			{
				int quantity = order.getQuantityReceived();
				int partNum = order.getProduct().getPartNumber();
				Inventory inventory = iservice.findInventoryByPartNumber(partNum);
				if (inventory==null) {
					return "forward:/inventory/add";
				}
				else {
					int newQuantity = inventory.getUnits() + quantity;
					inventory.setUnits(newQuantity);
					iservice.updateInventory(inventory);
					oservice.saveOrder(order);
					return "forward:/order/list";
				}
				
			}
			
			if(order.getStatus().toString()=="ReturnedToSupplier") 
			{
				int quantity = order.getQuantityReceived();
				int partNum = order.getProduct().getPartNumber();
				Inventory inventory = iservice.findInventoryByPartNumber(partNum);
				//System.out.println("!!!" + inventory.getUnits());
				if (inventory.getUnits()>quantity||inventory.getUnits()==quantity) 
				{
					int newQuantity = inventory.getUnits() - quantity;
					System.out.println("test!!!!!!" + newQuantity);
					if(newQuantity==0) 
					{
						iservice.deactivateInventory(inventory);
						//void sendNotification(String msg) throws MailException{
					}
					else 
					{
						Product product = pdtservice.findProductById(partNum);
						int reorderlvl = product.getReorderLevel();
						if(newQuantity<reorderlvl) {
							//void sendNotification(String msg) throws MailException{
						}
						inventory.setUnits(newQuantity);
						iservice.updateInventory(inventory);
					}
					oservice.saveOrder(order);
					return "forward:/order/list";
				}
				
				
			}return "order-form";
		}
		
			
		
		
	}
	
	@RequestMapping(value="/list")
	public String list(Model model)
	{
		model.addAttribute("orderList", oservice.listAllOrders());
		return "order";
	}
	
	@RequestMapping(value = "/edit/{orderId}")
	public String editForm(@PathVariable("orderId") int number, Model model) {
		model.addAttribute("order", oservice.findById(number));
		return "editOrder";
	}
	
	/*
	 * @RequestMapping(value = "/delete/{orderId}") public String
	 * deleteProduct(@PathVariable("orderId") int number) {
	 * oservice.deleteProduct(number); return "forward:/order/list"; }
	 */

}
