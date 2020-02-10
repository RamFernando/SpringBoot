package com.ramesha.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ramesha.training.Application;
import com.ramesha.training.model.Address;
import com.ramesha.training.model.Employee;
import com.ramesha.training.service.EmployeeService;

@RestController
@RequestMapping("/services")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/hello")
	public String greeting() {
		return "<h1>Hello from Spring Boot</h1>";
	}
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmployees(){
		return Employee.getAllEmployees();
	}
	
	@RequestMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		
		if (id==10) {
			Employee employee = new Employee();
			employee.setId(1);
			employee.setEmployeeName("Ramesha Prasadinie");
			employee.setEmployeeLocation("Kottawa");
			
			Address address = new Address();
			address.setId(1);
			address.setCity("Rukmalgama");
			employee.setAddress(address);
			
			return employee;
		}else {
			return new Employee();
		}
	}
	
	@RequestMapping(value="/employee/save", method = RequestMethod.POST)
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@RequestMapping(value = "/employee/findAll",method = RequestMethod.POST)
	public List<Employee> fetchAllEmployees(){
		return employeeService.findAll();
	}
}
