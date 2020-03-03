package com.ramesha.rentacar.repository;

import com.ramesha.rentacar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
