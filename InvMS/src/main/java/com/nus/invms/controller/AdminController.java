package com.nus.invms.controller;

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
import com.nus.invms.domain.Password;
import com.nus.invms.domain.Status;
import com.nus.invms.service.EmployeeImplementation;
import com.nus.invms.service.EmployeeInterface;


@Controller
@RequestMapping("/admin")
public class AdminController extends MechanicController {

	public AdminController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	EmployeeInterface empservice;
	
	@Autowired
	public void setUserImplementation (EmployeeImplementation empimpl) {
		this.empservice = empimpl;
	}
	
	@RequestMapping(value = "/add")
	public String add(Model model) 
	{
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "employee-form";
	}
	
	

	@RequestMapping(value = "/save")
	public String saveUser(@ModelAttribute("employee") @Valid Employee employee, 
			BindingResult bindingResult,  Model model) {
		
		if (bindingResult.hasErrors()) {
			return "employee-form";
		}

		if (employee.getID() == 0) {
			Employee emp = new Employee();
			emp.setUsername(employee.getUsername());
	        emp.setStatus(employee.getStatus());
	        emp.setEPassword(employee.getEPassword());
	        emp.setRole(employee.getRole());
	        emp.setName(employee.getName());
	        empservice.saveEmployee(emp);
	        return "forward:/admin/list";
		}
		else {
			Employee emp = empservice.findById(employee.getID());
			emp.setUsername(employee.getUsername());
			emp.setStatus(employee.getStatus());
			emp.setEPassword(employee.getEPassword());
			emp.setRole(employee.getRole());
			emp.setName(employee.getName());
			empservice.saveEmployee(emp);
			return "forward:/admin/list";
		}
		

	}
	
	@RequestMapping(value="/list")
	public String list(Model model)
	{
		model.addAttribute("employeeList", empservice.listAllEmployees());
		return "employee";
	}
	
	@RequestMapping(value = "/authenticate")
	public String authenticate (@ModelAttribute("employee") Employee employee, 
			BindingResult bindingResult, Model model, HttpSession session, Errors errors) 
	{
		
		
		if (empservice.findByName(employee.getUsername()) == null)
		{
			errors.rejectValue("username", "wrong username", "username not found in system");
		}
		else if (!empservice.authenticateEmployee(employee))
		{
			errors.rejectValue("epassword", "wrong password", "username/ password is incorrect");
		}
		else if (!empservice.checkEmployeeStatus(employee)) {
			errors.rejectValue("username", "invalid user", "Sorry, this user is deactivated from system");
		}
		
		if (bindingResult.hasErrors()) {
			return "login";
		}
		
		if (empservice.authenticateEmployee(employee))
		{
			Employee emp = empservice.findByName(employee.getUsername());
			session.setAttribute("empsession", emp);
			return "index";
		}


		return "forward:/admin/login";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String editForm(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", empservice.findById(id));
		return "editEmployee";
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deactivateEmployee(@PathVariable("id") int id) {
		Employee emp = empservice.findById(id);
		emp.setStatus(Status.INACTIVE);
		empservice.saveEmployee(emp);
		return "forward:/admin/list";
	}


}
