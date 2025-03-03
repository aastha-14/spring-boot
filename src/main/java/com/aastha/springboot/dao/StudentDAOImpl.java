package com.aastha.springboot.dao;

import com.aastha.springboot.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    // 1. define field for entity manager
    private EntityManager entityManager;

    // 2. inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // 3. implement save method
    @Override
    @Transactional // Required for update operation
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student getStudentById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll(){
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName desc", Student.class);
        // return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> searchStudent(String lastName){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theName", Student.class);
        // set query params
        theQuery.setParameter("theName", lastName);
        // return query result
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        // create Query
        entityManager.merge(theStudent);
        return;
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id){
        Student theStudent = getStudentById(id);
        entityManager.remove(theStudent);
        return;
    }

    @Override
    @Transactional
    public int deleteAll(){
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
