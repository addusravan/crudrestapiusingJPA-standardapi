package com.baseexample.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.baseexample.springboot.cruddemo.entity.Employee;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class EmployeeDaoImpHibernate implements EmployeeDao {
	
	
	
	
	private EntityManager entityManager;
	
	
	
	
	
    @Autowired
	public EmployeeDaoImpHibernate(EntityManager entityManager) {
	
		this.entityManager = entityManager;
	}





    
	@Override
	
	public List<Employee> FindAll() {
		// TODO Auto-generated method stub
		
		
		
		
		
		//get the current hibernate session
		
		Session currentsession=entityManager.unwrap(Session.class);
		//create a query
		Query<Employee>theQuery=currentsession.createQuery("From Employee",Employee.class);
		
		//execute query and get return list
		List<Employee>employees=theQuery.getResultList();
		
		//return the results
		return employees;
	}






	@Override
	public Employee findbyid(int theId) {
		Session currentsession=entityManager.unwrap(Session.class);
		Employee theEmployee=currentsession.get(Employee.class,theId);
		return theEmployee;
	}






	@Override
	public void save(Employee theEmployee) {
		Session currentsession=entityManager.unwrap(Session.class);
		currentsession.saveOrUpdate(theEmployee);
		
	}






	@Override
	public void DeleteEmployee(int theId) {
		Session currentsession=entityManager.unwrap(Session.class);
		Query theQuery=currentsession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}

}
