package com.aastha.springboot.dao;

import com.aastha.springboot.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

// entity manager dependency injection
@Component
public class StudentDAOImpl implements StudentDAO{
//    define private field for dependency
    private EntityManager entityManager;
//    define constructor for injection
    public StudentDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    public List<Student> findAll(){
//        create typed query
        TypedQuery<Student> result = entityManager.createQuery("FROM Student", Student.class);
//        return list
        List<Student> students = result.getResultList();
        return students;
    }
}
