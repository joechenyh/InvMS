package com.nus.invms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.Employee;
import com.nus.invms.domain.Password;
import com.nus.invms.service.EmployeeImplementation;
import com.nus.invms.service.EmployeeInterface;

@Controller
public class MechanicController {

	public MechanicController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	EmployeeInterface empservice;
	
	@Autowired
	public void setUserImplementation (EmployeeImplementation empimpl) {
		this.empservice = empimpl;
	}
	
	@RequestMapping(value = "/login")
	public String login(Model model) 
	{
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpSession session) 
	{
		session.removeAttribute("empsession");
		return "index";
	}
	
	@RequestMapping(value = "/update/{name}")
	public String update(@PathVariable("name") String name, Model model) 
	{
		model.addAttribute("employee", empservice.findByName(name));
		model.addAttribute("password", new Password());
		
		return "update";
		
	}

}
