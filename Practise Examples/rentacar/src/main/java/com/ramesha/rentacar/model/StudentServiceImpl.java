package com.ramesha.rentacar.model;

import com.ramesha.rentacar.repository.StudentRepository;
import com.ramesha.rentacar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> fetchStudentById(int id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            return student;
        }
        return null;
    }
}
