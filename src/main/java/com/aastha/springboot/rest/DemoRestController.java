package com.aastha.springboot.rest;

import com.aastha.springboot.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Aastha", "Gupta", "aastha@gmail.com"));
        students.add(new Student("John", "Doe", "johndoe@ggmail.com"));
        return students;
    }
}
