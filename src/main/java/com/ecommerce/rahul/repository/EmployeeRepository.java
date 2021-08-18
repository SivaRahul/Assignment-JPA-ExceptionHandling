package com.ecommerce.rahul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.rahul.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	List<Employee> findByLastName(String lastName);

	List<Employee> findByFirstName(String firstName);

	List<Employee> findByAgeGreaterThanEqual(int age);

	List<Employee> findBySalaryGreaterThanEqual(int salary);
	
	
	

}
