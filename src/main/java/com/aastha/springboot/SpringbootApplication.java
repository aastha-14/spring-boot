package com.aastha.springboot;

import com.aastha.springboot.dao.StudentDAO;
import com.aastha.springboot.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
//	this CommandLineRunner will run after all other beans are finished
	@Bean
public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
//		Java Lambda Expression
		return runner -> {
//			findAllStudents(studentDAO);
//			findStudentDetails(studentDAO);
//			createStudent(studentDAO);
			deleteStudent(studentDAO);
//			updateStudent(studentDAO);
		};
}
private void findAllStudents(StudentDAO studentDAO){
	System.out.println("Fetching all students...");
	List<Student> students = studentDAO.findAll();
	for(Student student:students){
		System.out.println(student);
	}
}
	private void findStudentDetails(StudentDAO studentDAO){
		System.out.println("Fetching student details...");
		Student student = studentDAO.findById(1);
		System.out.println(student);
	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating student...");
		Student newStudent = new Student("New", "Student", "newstudent@gmail.com");
		studentDAO.save(newStudent);
		System.out.println("Student Created...");
	}
	private void updateStudent(StudentDAO studentDAO){
		System.out.println("Updating student...");
		Student newStudent = new Student("Jane", "Smith", "newstudent@gmail.com");
		newStudent.setId(6);
		Student student = studentDAO.update(newStudent);
		System.out.println("Student Updated..." + student);
		findAllStudents(studentDAO);
	}
	private void deleteStudent(StudentDAO studentDAO){
		System.out.println("Deleting student...");
		int id = studentDAO.deleteById(1);
		System.out.println("Deleted student..." + id);
		findAllStudents(studentDAO);
	}
}
