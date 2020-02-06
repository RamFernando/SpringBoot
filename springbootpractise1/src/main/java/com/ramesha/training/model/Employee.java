package com.ramesha.training.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	String employeeName;
	int empMarks;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String employeeName, int empMarks) {
		this.employeeName=employeeName;
		this.empMarks=empMarks;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmpMarks() {
		return empMarks;
	}
	public void setEmpMarks(int empMarks) {
		this.empMarks = empMarks;
	}
	
	public static List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<>();
		
		Employee employee = new Employee();
		employee.setEmployeeName("Ramesha");
		employee.setEmpMarks(92);
		employees.add(employee);
		
		Employee employee1 = new Employee();
		employee1.setEmployeeName("Kavisha");
		employee1.setEmpMarks(98);
		employees.add(employee1);
		
		return employees;
	}
	
}
