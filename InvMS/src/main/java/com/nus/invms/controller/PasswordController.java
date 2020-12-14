package com.nus.invms.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nus.invms.domain.Employee;
import com.nus.invms.domain.Password;
import com.nus.invms.service.EmployeeImplementation;
import com.nus.invms.service.EmployeeInterface;
import com.nus.invms.validator.PasswordValidator;

@Controller
@RequestMapping("/password")
public class PasswordController {
	
	@Autowired
	EmployeeInterface empservice;
	
	@Autowired
	public void setUserImplementation (EmployeeImplementation empimpl) {
		this.empservice = empimpl;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new PasswordValidator());
	}
	
	@RequestMapping(value = "/updatePassword")
	public String update(
			@ModelAttribute("password") @Valid Password password,
			BindingResult bindingResult, Model model, HttpSession session)
	{
		
		
		if (bindingResult.hasErrors()) 
		{
			return "update";
		}
		
		Employee emp = empservice.findByName(password.getUserName());

		if (empservice.checkEmployeeNameExist(emp)) 
		{
			
			if (emp.getPassword().equals(password.getPassword()))
			{
				if (password.getNewPassword().equals(password.getConfNewPassword()) && !password.getNewPassword().isBlank() && !password.getConfNewPassword().isBlank())
				{
					emp.setPassword(password.getNewPassword());
					empservice.saveEmployee(emp);
					
					return "forward:/admin/list";
				}
			}
			
		}
		
		return "update";
		
	}

}
