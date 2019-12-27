package exercices.springrest;

import lombok.extern.slf4j.Slf4j;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	//static final Logger log = LoggerFactory.getLogger(Exemple01RestApplication.class);

  @Bean
  CommandLineRunner initDatabase(EmployeRepository repository) {
    return args -> {
      log.info("Preloading " + repository.save(new Employe("Bilbo Baggins", "burglar")));
      log.info("Preloading " + repository.save(new Employe("Frodo Baggins", "thief")));
    };
  }
}