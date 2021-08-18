package com.ecommerce.rahul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ecommerce.rahul.model.Employee;
import com.ecommerce.rahul.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	  @Autowired
	  EmployeeService empService;
	
	  @GetMapping("/{id}")
	  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
	    return empService.getEmployeeById(id);
	  }
	
	  @GetMapping
	  public ResponseEntity<List<Employee>> getAllEmployees(){
	    return new ResponseEntity<List<Employee>>(empService.getAllEmployees(),HttpStatus.OK);
	  }
	
	  @DeleteMapping("/{id}")
	  @ResponseStatus(HttpStatus.OK)
	  public ResponseEntity<String> deleteEmployeeById(@PathVariable ("id") int id){
	    return new ResponseEntity<String>(empService.deleteEmployeeById(id),HttpStatus.OK);
	  }
	  @PostMapping
	  @ResponseStatus(HttpStatus.CREATED)
	  public Employee addEmployee(@RequestBody Employee emp) {
	    return empService.addEmployee(emp);
	  }
	  @GetMapping("/lastname/{lastName}")
	  public List<Employee> getEmployeeByLastName(@PathVariable ("lastName") String lastName) {
	    return empService.getEmployeeByLastName(lastName);
	  }
	  @GetMapping("/firstname/{firstName}")
	  public ResponseEntity<List<Employee>> getEmployeeByFirstName(@PathVariable ("firstName") String firstName) {
	    return new ResponseEntity<List<Employee>>(empService.getEmployeeByFirstName(firstName),HttpStatus.OK);
	  }
	  @GetMapping("/age/{age}")
	  public ResponseEntity<List<Employee>> getEmployeeByAgeGreaterThanEqual(@PathVariable ("age") int age) {
		    return new ResponseEntity<List<Employee>>(empService.getEmployeeByAgeGreaterThanEqual(age),HttpStatus.OK);
	  }
	  @GetMapping("/salary/{salary}")
	  public ResponseEntity<List<Employee>> getEmployeeBySalaryGreaterThanEqual(@PathVariable ("salary") int salary) {
		    return new ResponseEntity<List<Employee>>(empService.getEmployeeBySalaryGreaterThanEqual(salary),HttpStatus.OK);
	  }
}