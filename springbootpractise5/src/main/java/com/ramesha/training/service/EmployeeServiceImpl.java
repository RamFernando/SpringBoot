package com.ramesha.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ramesha.training.commonmodel.Allocation;
import com.ramesha.training.model.Employee;
import com.ramesha.training.model.Telephone;
import com.ramesha.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// Rest template
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// Rest template
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {

		for (Telephone telephone : employee.getTelephones()) {
			telephone.setEmployee(employee);
		}
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> findById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee fetchAll(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {

			HttpEntity<String> stringHttpEntity = new HttpEntity<>("", new HttpHeaders());

			Employee employee1 = employee.get();
			
			ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange(
					"http://localhost:8081/services/allocation/" + id, HttpMethod.POST, stringHttpEntity,
					Allocation[].class);
			employee1.setAllocations(responseEntity.getBody());
			return employee1;
		} else
			return null;
	}

}
