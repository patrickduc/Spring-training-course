package com.example.accessingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Exemple20PersistenceApplication {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Exemple20PersistenceApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
    		System.out.println("Gestion d'entités");
    		Customer customer = new Customer("Patrick", "Duc");
    		repository.save(customer);
    		customer = new Customer("Claire", "Duc");
    		repository.save(customer);
    		customer = new Customer("Vincent", "Duc");
    		repository.save(customer);
    		customer = new Customer("Emma", "Duc");
    		repository.save(customer);
    		customer = new Customer("Sonia", "Luczak");
    		repository.save(customer);
    		for (Customer currentCustomer : repository.findAll()) {
    			System.out.println("Client : " + currentCustomer);
    		}
        };
    }

}
