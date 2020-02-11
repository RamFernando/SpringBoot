package com.ramesha.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ramesha.training.model.Employee;
import com.ramesha.training.model.Telephone;
import com.ramesha.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {		
		
		for (Telephone telephone : employee.getTelephones()) {
			telephone.setEmployee(employee);
		}
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> findById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	

}
