package com.aastha.springboot.rest;

import com.aastha.springboot.entity.Student;
import com.aastha.springboot.exception.StudentErrorResponse;
import com.aastha.springboot.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    private List<Student> students;

    // define @PostConstruct to load student data.. only once!
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Aastha", "Gupta", "aastha@gmail.com"));
        students.add(new Student("John", "Doe", "johndoe@ggmail.com"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if(studentId > students.size() || studentId < 0){
            throw new StudentNotFoundException("Student ID not found: " + studentId);
        }
        return students.get(studentId);
    }
}
