package com.training.allocation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.allocation.model.Allocation;
import com.training.allocation.service.AllocationService;

@RestController
@RequestMapping("/services")
public class AllocationController {
	
	@Autowired
	AllocationService allocationService;

	@RequestMapping("/hello")
	public String greeting() {
		return "<h1>Hello from Allocation Service</h1>";
	}
	
	@RequestMapping("/allocations")
	public List<Allocation> getAllocations() {
		return Allocation.getAllAllocations();
	}
	
	@RequestMapping("/allocation/{id}")
	public Allocation getAllocation(@PathVariable("id") int id) {
		if(id==10) {
			Allocation allocation = new Allocation();
			allocation.setEmpid(1);
			allocation.setStart("2018");
			allocation.setEnd("2022");
			allocation.setProjectCode("Code Green");
			
			return allocation;
		}else {
			return new Allocation();
		}
	}
	
	@RequestMapping(value = "/allocation/save", method = RequestMethod.POST)
	public Allocation saveAllocation(@RequestBody Allocation allocation) {
		return allocationService.save(allocation);
	}
}
