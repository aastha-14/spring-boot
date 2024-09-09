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
			findStudentDetails(studentDAO);
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
		Student student = studentDAO.findOne(1);
		System.out.println(student);
	}
}
