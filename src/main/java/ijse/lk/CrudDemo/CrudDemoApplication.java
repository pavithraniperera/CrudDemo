package ijse.lk.CrudDemo;

import ijse.lk.CrudDemo.Dao.StudentDao;
import ijse.lk.CrudDemo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return args -> {
			createStudent(studentDao);
		};
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
