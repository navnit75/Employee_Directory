package com.demo.employee_crud.service;

import java.util.List;

import com.demo.employee_crud.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
