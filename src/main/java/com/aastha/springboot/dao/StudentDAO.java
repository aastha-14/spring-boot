package com.aastha.springboot.dao;

import com.aastha.springboot.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
   Student findById(Integer studentId);

   void save(Student theStudent);

   Student update(Student theStudent);

   int deleteById(int id);
}
