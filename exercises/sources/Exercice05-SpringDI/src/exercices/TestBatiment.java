package exercices;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TestBatiment {

	public static void main(String arguments[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("exercices");
		context.refresh();

		Batiment batiment = (Batiment) context.getBean("Capitole");
		System.out.println("Batiment en " + batiment.composition() + " : " + batiment.affiche());

		context.close();
	}
}
