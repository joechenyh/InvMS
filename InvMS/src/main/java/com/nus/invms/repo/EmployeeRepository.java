package com.nus.invms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nus.invms.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	public Employee findEmployeeByUsername(String name);
}
