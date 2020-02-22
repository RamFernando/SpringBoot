package com.ramesha.training.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ramesha.training.commonmodel.Allocation;

@Entity
public class Employee {

//	AUTO Indicates that the persistence provider should pick an appropriate strategy for the particular database.
//
//	IDENTITY Indicates that the persistence provider must assign primary keys for the entity using database identity column.
//
//	SEQUENCE Indicates that the persistence provider must assign primary keys for the entity using database sequence column.
//
//	TABLE Indicates that the persistence provider must assign primary keys for the entity using an underlying database table to ensure uniqueness.	

	// Change column name
	// @Column(name = "EMP_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String name;

	String marks;

	@Transient
	Allocation[] allocations;

	public Allocation[] getAllocations() {
		return allocations;
	}

	public void setAllocations(Allocation[] allocations) {
		this.allocations = allocations;
	}

	@OneToOne(cascade = CascadeType.ALL)
	Address address;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Telephone.class, mappedBy = "employee")
	List<Telephone> telephones;

	public void addTelephone(Telephone tp) {
		telephones.add(tp);
		tp.setEmployee(this);
	}

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = { @JoinColumn(name = "e_id", referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "p_id", referencedColumnName = "id") })
	List<Project> projects;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

}