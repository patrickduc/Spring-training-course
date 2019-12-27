package exemples.spring.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAutowired {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("exemples.spring.formation");
		context.refresh();

		AnimalFactory fabrique = (AnimalFactory) context.getBean(AnimalFactory.class);

		System.out.println(fabrique.show());

		Selecteur selecteur = new Selecteur();
		for (int i = 0; i < 10; i++) {
			try {
				Animal animal = (Animal) fabrique.createAnimal(selecteur);
				System.out.println("Nom de l'animal : " + animal.getName());
			}
			catch (Exception e) {
				System.err.println("Exception : " + e);
			}
		}

		Animal oiseau = (Animal) context.getBean(Animal.class);
		System.out.println("Nom de l'animal : " + oiseau.getName());

		context.close();
	}
}
