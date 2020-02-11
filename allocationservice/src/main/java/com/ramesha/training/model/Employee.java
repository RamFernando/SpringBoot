package com.ramesha.training.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String employeeName;
	String employeeLocation;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address address;
	
	@OneToMany(targetEntity = Telephone.class,mappedBy = "employee")
	List<Employee> telephones;
	
	@ManyToMany
	@JoinTable(joinColumns = {@JoinColumn(name = "eid", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "pid", referencedColumnName = "id")})
	List<Employee> projects;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
