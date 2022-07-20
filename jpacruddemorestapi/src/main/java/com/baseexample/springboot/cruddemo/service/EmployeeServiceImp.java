package com.baseexample.springboot.cruddemo.service;

import java.util.List;

import com.baseexample.springboot.cruddemo.dao.EmployeeDao;
import com.baseexample.springboot.cruddemo.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class EmployeeServiceImp implements EmployeeService {
	
	
	private EmployeeDao employeeDao;
	
	
	
	
	
    @Autowired
	public EmployeeServiceImp(@Qualifier("jpaDaoimp") EmployeeDao employeeDao) {
		
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> FindAll() {
		// TODO Auto-generated method stub
		return employeeDao.FindAll();
	}

	@Override
	@Transactional
	public Employee findbyid(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findbyid(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		// TODO Auto-generated method stub
             employeeDao.save(theEmployee);
	}

	@Override
	@Transactional
	public void DeleteEmployee(int theId) {
		// TODO Auto-generated method stub
		employeeDao.DeleteEmployee(theId);
	}

}
