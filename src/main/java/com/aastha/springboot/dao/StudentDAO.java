package com.aastha.springboot.dao;

import com.aastha.springboot.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
   Student findOne(Integer studentId);
}
