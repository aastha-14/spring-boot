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
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			System.out.println("Hello world!");
			//	createStudent(studentDAO);
			//	getStudents(studentDAO);
			//	getAllStudents(studentDAO);
			//	searchStudentByLastName(studentDAO);

			//	updateStudent(studentDAO);

			//	deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};


	}
	private void createStudent(StudentDAO studentDAO){
		// 1. Create Student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("John", "Doe", "johnDoe@gmail.com");
		// 2. save the student object
		System.out.println("Saving student...");
		studentDAO.save(tempStudent);
		// 3. Display ID of the student object
		System.out.println("Saved Student. Generate ID: " + tempStudent.getId());
	}
	private void getStudents(StudentDAO studentDAO){

		Student student = studentDAO.getStudentById(1);
		System.out.println(student);
	}
	private void getAllStudents(StudentDAO studentDAO){

		List<Student> students = studentDAO.findAll();
		for (Student tempStudent: students){
			System.out.println(tempStudent);
		}
	}
	private void searchStudentByLastName(StudentDAO studentDAO){
		List<Student> students = studentDAO.searchStudent("Doe");
		for(Student tempStudent: students){
			System.out.println(tempStudent);
		}
	}
	private void updateStudent(StudentDAO studentDAO){
		// find student by id
		Student theStudent = studentDAO.getStudentById(1);
		System.out.println("Retrieved Student by ID" + theStudent);
		// change first name
		System.out.println("Updating student...");
		theStudent.setFirstName("Aasthaaaa");
		// update
		studentDAO.updateStudent(theStudent);
		System.out.println("Student Updated...");
		getAllStudents(studentDAO);
	}

	private void deleteStudent(StudentDAO studentDAO){
		System.out.println("Deleting Student..");
		studentDAO.deleteStudent(3);
		System.out.println("Student Deleted...");

		System.out.println("Fetching all students...");
		getAllStudents(studentDAO);
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting ALL Students...");
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println("Total rows deleted: " + rowsDeleted);
	}
}