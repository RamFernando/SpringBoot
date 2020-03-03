package com.ramesha.rentacar.controller;

import com.ramesha.rentacar.model.Student;
import com.ramesha.rentacar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/service")
public class MainController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String greeting(){
        return "Hello Springboot - GET";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String greetingPost(){
        return "Hello Springboot - POST";
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ResponseEntity<Optional<Student>> fetchStudent(@RequestParam int id){
        Optional<Student> student = studentService.fetchStudentById(id);
        if (student==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(student);
        }
    }
}
