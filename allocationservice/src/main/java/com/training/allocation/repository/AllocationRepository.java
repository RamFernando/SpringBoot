package com.training.allocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.allocation.model.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Integer>{

}
