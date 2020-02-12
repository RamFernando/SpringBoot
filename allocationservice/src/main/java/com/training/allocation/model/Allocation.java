package com.training.allocation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Allocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Integer empid;
	String start;
	String end;
	String projectCode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public static List<Allocation> getAllAllocations() {
		List<Allocation> allocations = new ArrayList<>();
		
		Allocation allocation = new Allocation();
		allocation.setEmpid(1);
		allocation.setStart("2017");
		allocation.setEnd("2020");
		allocation.setProjectCode("Code Green");
		allocations.add(allocation);
		
		return allocations;
	}

}
