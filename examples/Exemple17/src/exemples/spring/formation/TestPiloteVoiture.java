package exemples.spring.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TestPiloteVoiture {

	public static void main(String arguments[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("exemples.spring.formation");

		PiloteVoiture piloteVoiture = (PiloteVoiture) context.getBean("creePiloteVoiture");
		System.out.println("Pilote de la voiture " + piloteVoiture.id());

		context.close();
	}
}
