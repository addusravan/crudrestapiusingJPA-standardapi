package com.baseexample.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.baseexample.springboot.cruddemo.entity.Employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class JpaDaoimp implements EmployeeDao {
	
	private EntityManager entitymanager;
	
	
	
	
    @Autowired
	public JpaDaoimp(EntityManager entitymanager) {
		
		this.entitymanager = entitymanager;
	}

	@Override
	public List<Employee> FindAll() {
		
		Query theQuery=entitymanager.createQuery("From Employee");
		List<Employee>employees=theQuery.getResultList();
		return employees;
		
		
	}

	@Override
	public Employee findbyid(int theId) {
		Employee theEmployee=entitymanager.find(Employee.class,theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee=entitymanager.merge(theEmployee);
		 theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void DeleteEmployee(int theId) {
		Query theQuery=entitymanager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
