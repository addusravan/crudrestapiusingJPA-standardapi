package com.baseexample.springboot.cruddemo.rest;

import java.util.List;

import com.baseexample.springboot.cruddemo.dao.EmployeeDao;
import com.baseexample.springboot.cruddemo.entity.Employee;
import com.baseexample.springboot.cruddemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
	
		this.employeeService = employeeService;
	}


	@GetMapping("/employees")
	
	public List<Employee>findall(){
	
	
	
	    return employeeService.FindAll();
	
	

}
    @GetMapping("/employees/{employeeId}")	
    public Employee getEmployee(@PathVariable  int employeeId) {
	
	Employee theEmployee=employeeService.findbyid(employeeId);
	
	if (theEmployee==null) {
		 throw new RuntimeException("Employee is not found"+ employeeId);
	}
	
	return theEmployee;
	
}
    @PostMapping("/employees")	
    public Employee addEmployee(@RequestBody  Employee theEmployee) {
    	theEmployee.setId(0);
    	employeeService.save(theEmployee);
	   return theEmployee;
    
    }  
    
    
    
    
    @PutMapping("/employees")	
    public Employee updateEmployee(@RequestBody  Employee theEmployee) {
    	
    	
    	employeeService.save(theEmployee);
	   return theEmployee;
    
    }  
    
    
     
    
    
    
    
    
    
    
    
    
    
    @DeleteMapping("/employees/{employeeId}")	
    public String deleteEmployee(@PathVariable  int employeeId) {
	
	Employee theEmployee=employeeService.findbyid(employeeId);
	
	if (theEmployee==null) {
		 throw new RuntimeException("Employee is not found"+ employeeId);
	}
	employeeService.DeleteEmployee(employeeId);

	return "deleted employeeId"+employeeId;
    
    
    }
}
    
    
    

    
