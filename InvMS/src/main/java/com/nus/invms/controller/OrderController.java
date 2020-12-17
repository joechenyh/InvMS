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
import com.nus.invms.domain.Order;
import com.nus.invms.domain.RoleType;
import com.nus.invms.service.EmployeeInterface;
import com.nus.invms.service.OrderInterface;




@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderInterface oservice;
	
	@Autowired 
	EmployeeInterface empservice;
	
	@RequestMapping(value = "/add")
	public String add(Model model, HttpSession session) 
	{
		model.addAttribute("order", new Order());
		return "order-form";
	}
	
	
	
	@RequestMapping(value = "/save")
	public String saveOrder(@ModelAttribute("order") @Valid Order order, 
			BindingResult bindingResult,  Model model, Errors errors, HttpSession session) {
		
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
		
		if (order.getDateReceived().isBefore(order.getOrderDate()))
		{
			errors.rejectValue("dateReceived", "invalid date", "Please select receive date same as or later than order date");
		}
		
		if (bindingResult.hasErrors()) {
			return "order-form";
		}
		
		oservice.saveOrder(order);
		return "forward:/order/list";
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
	
	@RequestMapping(value = "/delete/{orderId}")
	public String deleteProduct(@PathVariable("orderId") int number) {
		oservice.deleteProduct(number);
		return "forward:/order/list";
	}

}
