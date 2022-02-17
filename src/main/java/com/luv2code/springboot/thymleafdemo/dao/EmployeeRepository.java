package com.luv2code.springboot.thymleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymleafdemo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	// that's it .. no need to write any code LOL!
	
	// add a method to sort by last name 
	// find all by | order by last name ascending
	// Spring Data jpa will parse the method name 
	// Looks for specific format and pattern creates appropriate query... behind the scenes 
	public List<Employee> findAllByOrderByLastNameAsc();
}
