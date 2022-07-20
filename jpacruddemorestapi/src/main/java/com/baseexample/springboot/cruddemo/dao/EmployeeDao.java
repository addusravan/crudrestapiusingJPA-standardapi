package com.baseexample.springboot.cruddemo.dao;

import java.util.List;

import com.baseexample.springboot.cruddemo.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee>FindAll();
	public Employee findbyid(int theId);
	public void save(Employee theEmployee);
	public void DeleteEmployee(int theId);
	

}
