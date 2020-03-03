package com.ramesha.rentacar.service;

import com.ramesha.rentacar.model.Student;

import java.util.Optional;

public interface StudentService {
    Student save (Student student);

    Optional<Student> fetchStudentById(int id);
}
