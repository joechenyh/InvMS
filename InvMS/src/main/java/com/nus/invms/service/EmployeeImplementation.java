package com.nus.invms.service;

import java.util.ArrayList;
import java.util.Iterator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nus.invms.domain.Employee;
import com.nus.invms.repo.EmployeeRepository;

@Service
@Transactional
public class EmployeeImplementation implements EmployeeInterface {

	@Autowired
	EmployeeRepository emprepo;

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		emprepo.save(employee);
		
	}

	@Override
	public ArrayList<Employee> listAllEmployees() {
		// TODO Auto-generated method stub
		return (ArrayList<Employee>) emprepo.findAll();
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		emprepo.delete(employee);
	}
	
	@Override
	public boolean checkEmployeeNameExist(Employee employee) {
		
		ArrayList<Employee> ulist = listAllEmployees();
		for (Iterator<Employee> iterator = ulist.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			if (emp.getUsername().equals(employee.getUsername())) {
		    	return true;
		    }
		}
		
		return false;
	}

	@Override
	public boolean authenticateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee dbuser = emprepo.findEmployeeByUsername(employee.getUsername());
		
		if (dbuser.getUsername().equals(employee.getUsername()) && dbuser.getPassword().equals(employee.getPassword()))
			return true;
		else
			return false;
	}

	@Override
	public Employee findByName(String name) {
		// TODO Auto-generated method stub
		return emprepo.findEmployeeByUsername(name);
	}
}
