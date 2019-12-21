package exercices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Voiture {

	@Autowired
	private Moteur moteur;

	@Autowired
	private Chassis chassis;

	public void affiche() {
		System.out.println("Voiture avec\n\t" + this.moteur.infos() + "\n\t" + this.chassis.infos());
	}
}
