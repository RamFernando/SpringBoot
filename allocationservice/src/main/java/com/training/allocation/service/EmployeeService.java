package com.training.allocation.service;

import java.util.List;

import com.training.allocation.model.Allocation;

public interface EmployeeService {
	public List<Allocation> getAllocationList();

	public Allocation save(Allocation allocation);

	public List<Allocation> findAllocationsByEid(Integer id);
}
