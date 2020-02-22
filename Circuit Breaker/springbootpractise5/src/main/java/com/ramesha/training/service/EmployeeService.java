package com.ramesha.training.service;

import java.util.List;
import java.util.Optional;

import com.ramesha.training.model.Employee;

public interface EmployeeService {

	Employee save(Employee e);

	Employee findById(int id);

	String deleteEmployee(int id);

	Employee fethAllEmployees(int id);
}
