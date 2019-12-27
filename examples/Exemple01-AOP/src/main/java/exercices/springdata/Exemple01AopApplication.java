package exercices.springdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Exemple01AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Exemple01AopApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        	List<Employe> liste = new ArrayList<>();

    		System.out.println("Ajout d'employés");
    		Employe customer = new Employe();
    		customer.setName("Patrick");
    		liste.add(customer);

    		customer = new Employe();
    		customer.setName("Claire");
    		liste.add(customer);

    		for (Employe employe : liste) {
    			System.out.println("Employe : " + employe.getName());
    		}
        };
    }
}
