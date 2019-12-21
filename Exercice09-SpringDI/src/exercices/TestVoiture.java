package exercices;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TestVoiture {

	public static void main(String arguments[]) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("exercices");

		Voiture laVoiture = (Voiture) context.getBean(Voiture.class);
		laVoiture.affiche();

		context.close();
	}
}
