package com.nus.invms.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nus.invms.domain.Employee;
import com.nus.invms.domain.Password;
import com.nus.invms.service.EmployeeImplementation;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.BindingResolver.Unique;


public class PasswordValidator implements Validator {

	//@Autowired
	//private EmployeeImplementation empservice;
	
//	@Autowired
//	public void setUserImplementation (EmployeeImplementation empimpl) {
//		this.empservice = empimpl;
//	}

	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Password ps = (Password) obj;
		if (!ps.getNewPassword().equals(ps.getConfNewPassword()))
		{
			errors.rejectValue("confNewPassword", "password mismatch", "New password is mismatch with confirm new password");
		}

	}

	
}
