package com.training.allocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.allocation.model.Allocation;
import com.training.allocation.repository.AllocationRepository;

@Service
public class AllocationServiceImpl implements AllocationService{

	@Autowired
	AllocationRepository allocationRepository;
	
	@Override
	public Allocation save(Allocation allocation) {
		return allocationRepository.save(allocation);
	}

}
