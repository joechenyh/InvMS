package com.nus.invms.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nus.invms.domain.Employee;
import com.nus.invms.domain.Password;
import com.nus.invms.service.EmployeeImplementation;
import com.nus.invms.service.EmployeeInterface;


public class PasswordValidator implements Validator {

	@Autowired
	EmployeeInterface empservice;
	
	@Autowired
	public void setUserImplementation (EmployeeImplementation empimpl) {
		this.empservice = empimpl;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Password.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Password ps = (Password) obj;
		if (!ps.getNewPassword().equals(ps.getConfNewPassword()))
		{
			errors.rejectValue("confNewPassword", "password mismatch", "New password is mismatch with confirm new password");
		}
		
		Employee emp = empservice.findByName(ps.getUserName());
		if (ps.getUserName().equals(emp.getUsername()))
		{
			errors.rejectValue("userName", "has existing username", "username is available in the system already");
		}
		
	}

	
}
