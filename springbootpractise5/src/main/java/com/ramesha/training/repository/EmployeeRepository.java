package com.ramesha.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ramesha.training.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
