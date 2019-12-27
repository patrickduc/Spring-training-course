package exemples.spring.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestComponent {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Voiture.class);
		/*
		context.scan("exemples.spring.formation");
		context.refresh();
		*/

		Voiture voiture = (Voiture) context.getBean("voiture");
		System.out.println("Fabriquant de la voiture : " + voiture.getManufacturer());

		context.close();
	}
}
