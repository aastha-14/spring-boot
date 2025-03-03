package com.aastha.springboot.dao;

import com.aastha.springboot.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student getStudentById(Integer id);
    List<Student> findAll();
    List<Student> searchStudent(String lastName);
    void updateStudent(Student theStudent);

    void deleteStudent(Integer id);
    int deleteAll();
}
