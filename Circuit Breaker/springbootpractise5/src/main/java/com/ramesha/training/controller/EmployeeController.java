package com.ramesha.training.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.TransactionalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ramesha.training.Application;
import com.ramesha.training.model.Address;
import com.ramesha.training.model.Employee;
import com.ramesha.training.model.Project;
import com.ramesha.training.model.Telephone;
import com.ramesha.training.service.EmployeeService;

@RestController
@RequestMapping("services")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/allocation/{id}")
	public Employee getAllemployees(@PathVariable int id) {
		Employee employee = employeeService.fethAllEmployees(id);
		return employee;
	}

	@RequestMapping("test")
	public Employee test() {
		Employee employee = new Employee();
		employee.setId(10);
		employee.setName("Ramesha");
		employee.setMarks("99");

		Address address = new Address();
		address.setCity("Rukmalgama");
		employee.setAddress(address);

		Telephone telephone = new Telephone();
		telephone.setNo(11989);

		Telephone telephone1 = new Telephone();
		telephone1.setNo(115258989);

		List<Telephone> list = new ArrayList<>();
		list.add(telephone);
		list.add(telephone1);

		employee.setTelephones(list);

		employee.getTelephones().stream().forEach(t -> {
			t.setEmployee(employee);
		});
		
		Project project = new Project();
		project.setName("project1");

		Project project1 = new Project();
		project1.setName("project2");

		List<Project> projectList = new ArrayList<Project>();
		projectList.add(project);
		projectList.add(project1);

		employee.setProjects(projectList);

		return employee;
	}

	@RequestMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		if (id == 0) {
			Employee employee = new Employee();
			employee.setId(10);
			employee.setName("Ramesha");
			return employee;
		} else {
			return employeeService.findById(id);
		}

	}

	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}

	@Transactional(rollbackOn = TransactionalException.class)
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee getEmployees(@RequestBody Employee e) {

		e.getTelephones().stream().forEach(t -> {
			t.setEmployee(e);
		});

		Employee eee = employeeService.save(e);
		return eee;
	}
}