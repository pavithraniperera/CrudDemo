package ijse.lk.CrudDemo;

import ijse.lk.CrudDemo.Dao.StudentDao;
import ijse.lk.CrudDemo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		//spring automatically inject studentDao
		return args -> {
			//createStudent(studentDao);
			//createMultipleStudents(studentDao);
			//readStudent(studentDao);
			//queryForStudent(studentDao);
			//queryForStudentsByLastName(studentDao);
			updateStudent(studentDao);
		};
	}

	private void updateStudent(StudentDao studentDao) {
		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDao.findById(studentId);

		// change first name to "John"
		System.out.println("Updating student ...");
		myStudent.setFirstName("John");

		// update the student
		studentDao.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDao studentDao) {
		// get a list of students
		List<Student> theStudents = studentDao.findByLastName("Doe");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDao studentDao) {
		List<Student> studentList = studentDao.findAll();
		for (Student s:studentList) {
			System.out.println(s);

		}
	}

	private void readStudent(StudentDao studentDao) {
		// create  a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDao.saveStudent(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDao.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDao studentDao) {
		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDao.saveStudent(tempStudent1);
		studentDao.saveStudent(tempStudent2);
		studentDao.saveStudent(tempStudent3);
	}

	private void createStudent(StudentDao studentDao) {
		//create the student
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		//save the student
		System.out.println("Saving the student ...");
		studentDao.saveStudent(tempStudent);

		//display saved student id
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}

	//commandLiner is from springboot framework. and executed after the spring beans have been loaded
	// The CommandLineRunner interface is specifically designed for running code at application startup.

}
