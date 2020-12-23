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
import com.nus.invms.domain.OrderStatus;
import com.nus.invms.domain.OrderType;
import com.nus.invms.domain.Product;
import com.nus.invms.domain.RoleType;
import com.nus.invms.domain.Status;
import com.nus.invms.domain.Supplier;
import com.nus.invms.service.EmployeeInterface;
import com.nus.invms.service.InventoryService;
import com.nus.invms.service.InventoryServiceImpl;
import com.nus.invms.service.NotificationService;
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
	NotificationService nservice;
	
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
		ArrayList<Product> pList = new ArrayList<Product>();
		ArrayList<Product> pList2 = new ArrayList<Product>();
		pList = (ArrayList<Product>) pdtservice.findAllProducts();
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
		return "order-form";
	}
	
	
	
	@RequestMapping(value = "/save")
	public String saveOrder(@ModelAttribute("order") @Valid Order order, 
			BindingResult bindingResult,  Model model, Errors errors, HttpSession session) 
	{
		
		Employee emp = (Employee) session.getAttribute("empsession");
		System.out.println("Save order");
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
		
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("order", order);
			ArrayList<Product> pList = new ArrayList<Product>();
			ArrayList<Product> pList2 = new ArrayList<Product>();
			pList = (ArrayList<Product>) pdtservice.findAllProducts();
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
			return "order-form";
		}
		ArrayList<Order> oList = new ArrayList<Order>();
		oList = (ArrayList<Order>) oservice.listAllOrders();
		for (Iterator <Order> iterator = oList.iterator(); iterator.hasNext();) 
		{
			Order order2 = iterator.next();
			if(order2.getpOnum()==order.getpOnum()) {
				model.addAttribute("order", order);
				ArrayList<Product> pList = new ArrayList<Product>();
				ArrayList<Product> pList2 = new ArrayList<Product>();
				pList = (ArrayList<Product>) pdtservice.findAllProducts();
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
				
				model.addAttribute("message","Duplicate PO Number");
				return "order-form";
			}
			
		}
		
		 {
			if(order.getStatus().toString()=="OrderReceived") 
			{
				int quantityReceive = order.getQuantityReceived();
				int partNum = order.getProduct().getPartNumber();
				Inventory inventory = iservice.findInventoryByPartNumber(partNum);
				if (inventory==null) {
					
					return "forward:/inventory/add";
				}
				else {
					int newQuantity = inventory.getUnits() + quantityReceive;
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
				if (inventory.getUnits()>quantity||inventory.getUnits()==quantity) 
				{
					int newQuantity = inventory.getUnits() - quantity;
					System.out.println("test!!!!!!" + newQuantity);
					if(newQuantity==0) 
					{
						Product product = pdtservice.findProductById(partNum);
						iservice.deactivateInventory(inventory);
						String mail = "Product " + product.getProductName() + " Part Number: " + product.getPartNumber() + " has reach 0. This product will be removed from the inventory list.";
						nservice.sendNotification(mail);
						
					}
					else 
					{
						Product product = pdtservice.findProductById(partNum);
						int reorderlvl = product.getReorderLevel();
						if(newQuantity<reorderlvl) {
							String mail = "Product " + product.getProductName() + " Part Number: " + product.getPartNumber() + " has reach below reorder level. Time to replenish.";
							nservice.sendNotification(mail);
						}
						inventory.setUnits(newQuantity);
						iservice.updateInventory(inventory);
					}
					oservice.saveOrder(order);
					return "forward:/order/list";
				}
				
				
			}
			if(order.getType()==OrderType.RETURN) {
				order.setQuantityReceived(order.getQuantityOrdered());
			}
			oservice.saveOrder(order);
			return "forward:/order/list";
		}
		
			
		
		
	}
	
	@RequestMapping(value="/list")
	public String list(Model model)
	{
		model.addAttribute("orderList", oservice.listAllOrders());
		return "order";
	}
	
	
	@RequestMapping(value = "/edit/{orderId}")
	public String add1(@PathVariable("orderId") int number, Model model, HttpSession session) 
	{
		
		
		model.addAttribute("order", oservice.findById(number));
		ArrayList<Product> pList = new ArrayList<Product>();
		ArrayList<Product> pList2 = new ArrayList<Product>();
		pList = (ArrayList<Product>) pdtservice.findAllProducts();
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
		return "editOrder";
	}
	
	@RequestMapping(value = "/arrive/{orderId}")
	public String editForm(@PathVariable("orderId") int number, Model model) {
		model.addAttribute("order", oservice.findById(number));
		ArrayList<Product> plist = pdtservice.findAllProducts();
		model.addAttribute("products",plist);
		ArrayList<Supplier> slist = supservice.listAllSuppliers();
		model.addAttribute("suppliers",slist);
		return "arriveOrder";
	}
	
	@RequestMapping(value = "/confirmArrive")
	public String receiveOrder(@ModelAttribute("order") @Valid Order order, 
			BindingResult bindingResult,  Model model, Errors errors, HttpSession session) 
	{
		
		Employee emp = (Employee) session.getAttribute("empsession");
		System.out.println("Save order");
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
		

		
		if (bindingResult.hasErrors()||order.getDateReceivedReturned()==null||order.getQuantityReceived()==0) {
			model.addAttribute("order", order);
			ArrayList<Product> plist = pdtservice.findAllProducts();
			model.addAttribute("products",plist);
			ArrayList<Supplier> slist = supservice.listAllSuppliers();
			model.addAttribute("suppliers",slist);
			model.addAttribute("message", "Missing Input");
			return "arriveOrder";
		}
		 {
			if(order.getStatus().toString()=="OrderReceived") 
			{
				ArrayList<Order> oList = new ArrayList<Order>();
				oList = (ArrayList<Order>) oservice.listAllOrders();
				int quantityReceive = order.getQuantityReceived();
				for (Iterator<Order> iterator = oList.iterator(); iterator.hasNext();) {
					Order order2 = iterator.next();
					if(order.getpOnum()==order2.getpOnum()) 
					{
						quantityReceive+=order2.getQuantityReceived();
					}
					
				}
				
				int partNum = order.getProduct().getPartNumber();
				int quantityOrder = order.getQuantityOrdered();
				Inventory inventory = iservice.findInventoryByPartNumber(partNum);
				if (inventory==null) 
				{
					Order newOrder = new Order();
					
					if(quantityReceive<quantityOrder) {
						
						newOrder.setOrderDate(order.getOrderDate());
						newOrder.setQuantityOrdered(order.getQuantityOrdered());
						newOrder.setType(order.getType());
						newOrder.setStatus(OrderStatus.OrderNotYetReceived);
						newOrder.setEmployee(order.getEmployee());
						newOrder.setSupplier(order.getSupplier());
						newOrder.setProduct(order.getProduct());
						newOrder.setpOnum(order.getpOnum());
						oservice.saveOrder(newOrder);
						
					}
					oservice.saveOrder(order);
					
					return "forward:/inventory/add";
				}
				
					
				
				else {
					int newQuantity = inventory.getUnits() + quantityReceive;
					inventory.setUnits(newQuantity);
					iservice.updateInventory(inventory);
					Order newOrder = new Order();
					System.out.println("35: " + quantityReceive);
					if(quantityReceive<quantityOrder) {
						
						newOrder.setOrderDate(order.getOrderDate());
						newOrder.setQuantityOrdered(order.getQuantityOrdered());
						newOrder.setType(order.getType());
						newOrder.setStatus(OrderStatus.OrderNotYetReceived);
						newOrder.setEmployee(order.getEmployee());
						newOrder.setSupplier(order.getSupplier());
						newOrder.setProduct(order.getProduct());
						newOrder.setpOnum(order.getpOnum());
						oservice.saveOrder(newOrder);
						
					}
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
						String msg = "reach 0";
						//nservice.sendNotification(msg);
						
					}
					else 
					{
						Product product = pdtservice.findProductById(partNum);
						int reorderlvl = product.getReorderLevel();
						if(newQuantity<reorderlvl) {
							String msg = "reorder";
							//nservice.sendNotification(msg);
						}
						inventory.setUnits(newQuantity);
						iservice.updateInventory(inventory);
					}
					oservice.saveOrder(order);
					return "forward:/order/list";
				}
				
				
			}
			oservice.saveOrder(order);
			return "forward:/order/list";
		}
		
			
		
		
	}
	
	@RequestMapping(value = "/return/{orderId}")
	public String returnForm(@PathVariable("orderId") int number, Model model) {
		model.addAttribute("order", oservice.findById(number));
		ArrayList<Product> plist = pdtservice.findAllProducts();
		model.addAttribute("products",plist);
		ArrayList<Supplier> slist = supservice.listAllSuppliers();
		model.addAttribute("suppliers",slist);
		return "returnOrder";
	}
	
	@RequestMapping(value = "/confirmReturn") 
	public String returnOrder(@ModelAttribute("order") @Valid Order order, 
			BindingResult bindingResult,  Model model, Errors errors, HttpSession session) 
	{
		
		Employee emp = (Employee) session.getAttribute("empsession");
		System.out.println("Save order");
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
		
//		if (order.getDateReceivedReturned() != null) {
//			if (order.getDateReceivedReturned().isBefore(order.getOrderDate()))
//			{
//				errors.rejectValue("dateReceived", "invalid date", "Please select receive date same as or later than order date");
//			}
//		}
		
		if (bindingResult.hasErrors()||order.getDateReceivedReturned()==null||order.getQuantityReceived()==0) {
			model.addAttribute("order", order);
			ArrayList<Product> plist = pdtservice.findAllProducts();
			model.addAttribute("products",plist);
			ArrayList<Supplier> slist = supservice.listAllSuppliers();
			model.addAttribute("suppliers",slist);
			model.addAttribute("message", "Missing Input");
			return "returnOrder";
		}
		 {
			if(order.getStatus().toString()=="OrderReceived") 
			{
				ArrayList<Order> oList = new ArrayList<Order>();
				oList = (ArrayList<Order>) oservice.listAllOrders();
				int quantityReceive = order.getQuantityReceived();
				for (Iterator<Order> iterator = oList.iterator(); iterator.hasNext();) {
					Order order2 = iterator.next();
					if(order.getpOnum()==order2.getpOnum()) {
						quantityReceive+=order2.getQuantityReceived();
					}
					
				}
				int partNum = order.getProduct().getPartNumber();
				int quantityOrder = order.getQuantityOrdered();
				Inventory inventory = iservice.findInventoryByPartNumber(partNum);
				if (inventory==null) 
				{
					Order newOrder = new Order();
					
					if(quantityReceive<quantityOrder) {
						
						newOrder.setOrderDate(order.getOrderDate());
						newOrder.setQuantityOrdered(order.getQuantityOrdered());
						newOrder.setType(order.getType());
						newOrder.setStatus(OrderStatus.OrderNotYetReceived);
						newOrder.setEmployee(order.getEmployee());
						newOrder.setSupplier(order.getSupplier());
						newOrder.setProduct(order.getProduct());
						newOrder.setpOnum(order.getpOnum());
						oservice.saveOrder(newOrder);
						
					}
					oservice.saveOrder(order);
					
					return "forward:/inventory/add";
				}
				else {
					int newQuantity = inventory.getUnits() + quantityReceive;
					inventory.setUnits(newQuantity);
					iservice.updateInventory(inventory);
					Order newOrder = new Order();
					System.out.println("35: " + quantityReceive);
					if(quantityReceive<quantityOrder) {
						
						newOrder.setOrderDate(order.getOrderDate());
						newOrder.setQuantityOrdered(order.getQuantityOrdered());
						newOrder.setType(order.getType());
						newOrder.setStatus(OrderStatus.OrderNotYetReceived);
						newOrder.setEmployee(order.getEmployee());
						newOrder.setSupplier(order.getSupplier());
						newOrder.setProduct(order.getProduct());
						newOrder.setpOnum(order.getpOnum());
						oservice.saveOrder(newOrder);
						
					}
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
						Product product = pdtservice.findProductById(partNum);
						String mail = "Product " + product.getProductName() + " Part Number: " + product.getPartNumber() + " has reach 0. Time to replenish.";
						nservice.sendNotification(mail);
						
					}
					else 
					{
						Product product = pdtservice.findProductById(partNum);
						int reorderlvl = product.getReorderLevel();
						if(newQuantity<reorderlvl) {
							String mail = "Product " + product.getProductName() + " Part Number: " + product.getPartNumber() + " has reach below reorder level. Time to replenish.";
							nservice.sendNotification(mail);
						}
						inventory.setUnits(newQuantity);
						iservice.updateInventory(inventory);
					}
					oservice.saveOrder(order);
					return "forward:/order/list";
				}
				
				
			}
			oservice.saveOrder(order);
			return "forward:/order/list";
		}	
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteOrder(@PathVariable("id") Integer id) {
		oservice.deleteById(id);
		return "forward:/order/list";
	}
	
	@RequestMapping(value = "/editsave")
	public String editSaveOrder(@ModelAttribute("order") @Valid Order order, 
			BindingResult bindingResult,  Model model, Errors errors, HttpSession session) 
	{
		
		Employee emp = (Employee) session.getAttribute("empsession");
		System.out.println("Save order");
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
		

		
		if (bindingResult.hasErrors()) {
			return "order-form";
		}
		
		 {
			if(order.getStatus().toString()=="OrderReceived") 
			{
				int quantityReceive = order.getQuantityReceived();
				int partNum = order.getProduct().getPartNumber();
				Inventory inventory = iservice.findInventoryByPartNumber(partNum);
				if (inventory==null) {
					
					return "forward:/inventory/add";
				}
				else {
					int newQuantity = inventory.getUnits() + quantityReceive;
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
						Product product = pdtservice.findProductById(partNum);
						iservice.deactivateInventory(inventory);
						String mail = "Product " + product.getProductName() + " Part Number: " + product.getPartNumber() + " has reach 0. This product will be removed from the inventory list.";
						nservice.sendNotification(mail);
						
					}
					else 
					{
						Product product = pdtservice.findProductById(partNum);
						int reorderlvl = product.getReorderLevel();
						if(newQuantity<reorderlvl) {
							String mail = "Product " + product.getProductName() + " Part Number: " + product.getPartNumber() + " has reach below reorder level. Time to replenish.";
							nservice.sendNotification(mail);
						}
						inventory.setUnits(newQuantity);
						iservice.updateInventory(inventory);
					}
					oservice.saveOrder(order);
					return "forward:/order/list";
				}
				
				
			}
			if(order.getType()==OrderType.RETURN) {
				order.setQuantityReceived(order.getQuantityOrdered());
			}
			oservice.saveOrder(order);
			return "forward:/order/list";
		}
	}

}
