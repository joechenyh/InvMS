package com.nus.invms.service;

import java.util.ArrayList;

import com.nus.invms.domain.Employee;

public interface EmployeeInterface {
	
	public void saveEmployee(Employee employee);
	public ArrayList<Employee> listAllEmployees();
	public boolean checkEmployeeNameExist(Employee employee);
	public boolean authenticateEmployee(Employee employee);
	public Employee findByName(String name);
	public Employee findById(int id);
	public boolean checkEmployeeStatus(Employee employee);
	

}
