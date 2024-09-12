package com.learning.demo;

import com.learning.demo.dao.StudentDAO;
import com.learning.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			removeStudent(studentDAO);
//			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println(("Deleted all students: " + numRowsDeleted));
	}

	private void removeStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id...");
		studentDAO.delete(studentId);
		System.out.println("Deleted student successfully.");
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on id
		Student student = studentDAO.findById(1);
		student.setLastName("Dovani");
		studentDAO.update(student);
		System.out.println("Updated student: "+ student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theFoundStudents = studentDAO.findByFirstName("Bonita");
		for(Student tempStudent: theFoundStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student theStudent = studentDAO.findById(1);
		System.out.println("The searched student is: " + theStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating new student objects...");
		Student student1 = new Student("Paul", "Doe", "pauldoe@gmail.com");
		Student student2 = new Student("Mary", "Doe", "marydoe@gmail.com");
		Student student3 = new Student("Bonita", "Doe", "bonitadoe@gmail.com");

		// save the student object
		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		// display the id of the saved student
		System.out.println("Saved students.");
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student student = new Student("Paul", "Doe", "pauldoe@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(student);

		// display the id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}

}
