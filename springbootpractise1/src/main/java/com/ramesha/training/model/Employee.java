package com.ramesha.training.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	String employeeName;
	String employeeLocation;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeLocation() {
		return employeeLocation;
	}
	public void setEmployeeLocation(String employeeLocation) {
		this.employeeLocation = employeeLocation;
	}
	
	public static List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee employee = new Employee();
		employee.setEmployeeName("Ramesha");
		employee.setEmployeeLocation("Kottawa");
		employees.add(employee);
		
		return employees;
	}
	
}
