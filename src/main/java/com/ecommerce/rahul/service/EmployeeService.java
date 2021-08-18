package com.ecommerce.rahul.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.rahul.model.Employee;
import com.ecommerce.rahul.repository.EmployeeRepository;
import com.ecommerce.rahul.exception.ResourceNotFoundException;
import com.ecommerce.rahul.exception.SearchResultNotFoundException;

@Service
public class EmployeeService {
	  @Autowired
	  private EmployeeRepository repository;
	
	  public ResponseEntity<Employee> getEmployeeById(int id) {
	    Employee employee=repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "EmployeeId", id));
	    return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	  }
	
	  public List<Employee> getAllEmployees(){
	    List<Employee> employees= repository.findAll();
	    if(employees.isEmpty()) {
	    	throw new SearchResultNotFoundException("Search Details Not Found or List is Empty");
	    }
	    return employees;
		
	  }
	
	  public String deleteEmployeeById(int id){
		  Optional<Employee> employee=repository.findById(id);
		  if(employee.isEmpty()) {
			 throw new ResourceNotFoundException("Employee", "EmployeeId", id);
		  }
		  
		  
		  repository.deleteById(id);
		  return "Employee with EmployeeId: "+id+" Deleted";
	  }
	
	  public Employee addEmployee(Employee emp) {
	    return repository.save(emp);
	  }
	  
	  public List<Employee> getEmployeeByFirstName(String firstName) {
		  List<Employee> employees=repository.findByFirstName(firstName);
		  if(employees.isEmpty()){
			  throw new SearchResultNotFoundException("There is no Employee with firstname :: "+firstName);
		  }
		  return employees;
		    
	  }
	
	  public List<Employee> getEmployeeByLastName(String lastName) {
		  List<Employee> employees=repository.findByLastName(lastName);
		  if(employees.isEmpty()){
			  throw new SearchResultNotFoundException("There is no Employee with lastname :: "+lastName);
		  }
		  return employees;
	  }
	  
	  public List<Employee> getEmployeeByAgeGreaterThanEqual(int age) {
		  List<Employee> employees= repository.findByAgeGreaterThanEqual(age);
		  if(employees.isEmpty()){
			  throw new SearchResultNotFoundException("There is no Employee with Age greater than :: "+age);
		  }
		  return employees;
	  }
	  public List<Employee> getEmployeeBySalaryGreaterThanEqual(int salary) {
		  List<Employee> employees= repository.findByAgeGreaterThanEqual(salary);
		  if(employees.isEmpty()){
			  throw new SearchResultNotFoundException("There is no Employee with Salary greater than :: "+salary);
		  }
		  return employees;
	  }
	  

}
