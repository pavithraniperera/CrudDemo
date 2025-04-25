package ijse.lk.CrudDemo;

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
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Hello world");
		};
	}

	//commandLiner is from springboot framework. and executed after the spring beans have been loaded
	// The CommandLineRunner interface is specifically designed for running code at application startup.

}
