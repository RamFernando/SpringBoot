package com.training.allocation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.training.allocation.model.Allocation;
import com.training.allocation.repository.AllocationRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	AllocationRepository employeeRepository;
	// DAO EKA

	@Override
	public List<Allocation> getAllocationList() {
		return employeeRepository.findAll();
	}

	@Override
	public Allocation save(Allocation allocation) {
		Allocation allocation1 = employeeRepository.save(allocation);
		return allocation1;
	}

	public List<Allocation> findAllocationsByEid(Integer Eid) {

		// make empty
		Allocation emptyAllocationWithEid = new Allocation();
		emptyAllocationWithEid.setEmpid(Eid);

		Example<Allocation> example = Example.of(emptyAllocationWithEid);

		List<Allocation> all = employeeRepository.findAll(example);

		return all;
	}

}