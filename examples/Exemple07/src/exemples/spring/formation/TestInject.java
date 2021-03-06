package exemples.spring.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestInject {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("exemples.spring.formation");
		context.refresh();

		Voiture voiture = (Voiture) context.getBean("voiture");
		
		System.out.println("Infos sur la voiture : " + voiture.getInformations());

		context.close();
	}
}
