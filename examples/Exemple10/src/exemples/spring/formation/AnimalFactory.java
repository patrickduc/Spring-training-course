package exemples.spring.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("animalFactory")
public class AnimalFactory {

	@Autowired
	public Animal createAnimal(Selecteur selecteur) throws Exception {

		Animal animal = null;

		switch (selecteur.getCompteur() % 2) {
		case 0:
			animal = new Bird();
			break;
		case 1:
			animal = new Dog();
			break;
		}

		if (animal == null) {
			throw new Exception("Unknown animal type");
		}
		
		selecteur.incrementCompteur();

		return animal;
	}
	
	public String show() {
		return "Je suis une fabrique d'animaux";
	}
}
