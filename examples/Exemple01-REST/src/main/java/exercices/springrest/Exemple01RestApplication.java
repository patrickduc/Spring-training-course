package exercices.springrest;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Exemple01RestApplication {

	//static final Logger log = LoggerFactory.getLogger(Exemple01RestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Exemple01RestApplication.class, args);
		log.info("Spring Boot application started");
	}

	/*
	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
			logger.info("Preloading " + repository.save(new Employe("Bilbo Baggins", "burglar")));
			logger.info("Preloading " + repository.save(new Employe("Frodo Baggins", "thief")));
		};
	}
	*/
}
