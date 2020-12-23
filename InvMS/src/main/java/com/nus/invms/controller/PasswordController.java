package com.nus.invms.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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
	

	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new PasswordValidator());
	}
	
	@RequestMapping(value = "/updatePassword")
	public String update(
			@ModelAttribute("password") @Valid Password password,
			BindingResult bindingResult, Model model, HttpSession session, Errors errors)
	{
		Employee emp = (Employee) session.getAttribute("empsession");
		if (!password.getPassword().equals(emp.getEPassword()))
		{
			errors.rejectValue("password", "password mismatch", "Current password is incorrect");
		}
		
			
		if (bindingResult.hasErrors()) 
		{
			System.out.println("There are errors");
			return "update";
		}
		
		

		if (empservice.checkEmployeeNameExist(emp)) 
		{
			System.out.println("Employee Name Exists ");
			
			if (emp.getEPassword().equals(password.getPassword()))
			{
				System.out.println("Current password verified ");
				if (password.getNewPassword().equals(password.getConfNewPassword()) 
						&& !password.getNewPassword().isBlank() && !password.getConfNewPassword().isBlank())
				{
					//System.out.println("Prepare to update password, final step:");
					emp.setEPassword(password.getNewPassword());
					empservice.saveEmployee(emp);
					
					return "updatedPassword";
				}
			}
			
		}
		
		return "update";
		
	}

}
