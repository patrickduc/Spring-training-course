package exemples.spring.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAutowired {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("exemples.spring.formation");
		context.refresh();

		// Equivalent de : 
		// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("exemples.spring.formation");

		Voiture voiture = (Voiture) context.getBean("voiture");
	
		System.out.println("Infos sur la voiture : " + voiture.getInformations());

		context.close();
	}
}
