package com.aastha.springboot.dao;

import com.aastha.springboot.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
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
        return result.getResultList();
    }
    public Student findById(Integer studentId){
        //        create typed query
        //        return list
        return entityManager.find(Student.class, studentId);
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        theStudent.setId(0); // this indicates that merge will perform create operation
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public Student update(Student theStudent) {
        return entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public int deleteById(int id) {
        Student student = findById(id);
        entityManager.remove(student);
        return id;
    }
}
