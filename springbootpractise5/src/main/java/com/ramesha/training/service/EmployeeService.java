package com.ramesha.training.service;

import java.util.List;
import java.util.Optional;

import com.ramesha.training.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	Optional<Employee> findById(Integer id);
	Employee fetchAll(int id);
}
