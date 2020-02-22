package com.training.allocation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.allocation.model.Allocation;
import com.training.allocation.service.EmployeeService;

@RestController
@RequestMapping("/services")
public class AllocationController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/test")
	public Allocation getTest() {
		Allocation allocation = new Allocation();
		allocation.setEmpid(1);
		allocation.setEndDate("4");
		allocation.setStartDate("1");
		allocation.setProjectName("Ramesha Fernando");

		return allocation;
	}

	@RequestMapping("/allocations")
	public List<Allocation> getAllocations() {
		return employeeService.getAllocationList();
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public Allocation getAllocation(@RequestBody Allocation allocation) {
		Allocation allocation1 = employeeService.save(allocation);
		return allocation1;
	}

	@RequestMapping("/getbyid/{id}")
	public List<Allocation> allocations(@PathVariable Integer id) {
		System.out.println("*********************************1");
		List<Allocation> allocation = employeeService.findAllocationsByEid(id);
		return allocation;
	}

}