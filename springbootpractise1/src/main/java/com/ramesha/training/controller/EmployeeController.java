package com.ramesha.training.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramesha.training.model.Employee;

@RestController
@RequestMapping("/services")
public class EmployeeController {

	@RequestMapping("/hello")
	public String greeting() {
		return "<h1>Hello from Spring Boot</h1>";
	}
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmployees(){
		return Employee.getAllEmployees();
	}
	
}
