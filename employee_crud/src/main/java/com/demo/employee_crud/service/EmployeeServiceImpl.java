package com.demo.employee_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employee_crud.dao.EmployeeRepository;
import com.demo.employee_crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	// Remove @Transactional as JPA repo provides that functionality
	private EmployeeRepository employeeRepository; 
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if(result.isPresent())
			theEmployee = result.get();
		else
			// we didn't find the employee 
			throw new RuntimeException("Did not find the employee id - "+theId);
		return theEmployee; 
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);

	}

}
