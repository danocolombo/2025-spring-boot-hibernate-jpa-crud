package com.fortsonguru.cruddemo;

import com.fortsonguru.cruddemo.dao.StudentDAO;
import com.fortsonguru.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating a new student object");
		Student tempStudent = new Student("Paul", "Wall", "pwall@email.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display the id for the inserted student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}


}