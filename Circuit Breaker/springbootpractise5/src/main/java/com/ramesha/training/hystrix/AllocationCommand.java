package com.ramesha.training.hystrix;

import java.net.http.HttpHeaders;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.ramesha.training.commonmodel.Allocation;
import com.ramesha.training.model.Employee;

public class AllocationCommand extends HystrixCommand<Allocation[]> {

	private Employee employee;
	private HttpHeaders httpHeaders;
	private RestTemplate restTemplate;

	public AllocationCommand(Employee employee, HttpHeaders httpHeaders, RestTemplate restTemplate) {
		super(HystrixCommandGroupKey.Factory.asKey("default"));
		this.employee = employee;
		this.httpHeaders = httpHeaders;
		this.restTemplate = restTemplate;
	}

	@Override
	protected Allocation[] run() throws Exception {
		
		HttpEntity<String> httpEntity = new HttpEntity<>("",new org.springframework.http.HttpHeaders());

		ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange("http://allocation/services/getbyid/" + employee.getId(),
				HttpMethod.GET, httpEntity, Allocation[].class);
		
		return responseEntity.getBody();
	}
	
	@Override
	protected Allocation[] getFallback() {
		return new Allocation[0];
	}

}
