package com.nus.invms.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
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

//	@Autowired
//	private MessageSource messageSource;

//	@Autowired
//	public void setUserImplementation (EmployeeImplementation empimpl) {
//		this.empservice = empimpl;
//	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new PasswordValidator());
	}

	@RequestMapping(value = "/updatePassword")
	public String update(@ModelAttribute("password") @Valid Password password, BindingResult bindingResult, Model model,
			HttpSession session, Errors errors) {
		Employee emp = (Employee) session.getAttribute("empsession");
		if (!password.getPassword().equals(emp.getEPassword())) {
			errors.rejectValue("password", "password mismatch", "Current password is incorrect");
		}

		if (bindingResult.hasErrors()) {
			/*
			 * for (Object object : bindingResult.getAllErrors()) { if(object instanceof
			 * FieldError) { FieldError fieldError = (FieldError) object;
			 * 
			 *//**
				 * Use null as second parameter if you do not use i18n (internationalization)
				 *//*
					 * 
					 * String message = messageSource.getMessage(fieldError, null);
					 * 
					 * System.out.println(message); } }
					 */

			return "update";
		}

		if (empservice.checkEmployeeNameExist(emp)) {

			if (emp.getEPassword().equals(password.getPassword())) {
				if (password.getNewPassword().equals(password.getConfNewPassword())
						&& !password.getNewPassword().isBlank() && !password.getConfNewPassword().isBlank()) {
					emp.setEPassword(password.getNewPassword());
					empservice.saveEmployee(emp);

					return "updatedPassword";
				}

			}

		}

		return "update";

	}

}
