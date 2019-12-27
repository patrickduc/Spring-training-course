package exemples.spring.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("voiture")
public class Voiture {

	private Moteur moteur;

	public Voiture() {
	}

	@Autowired
	public Voiture(Moteur unMoteur) {
		this.moteur = unMoteur;
	}

	public String getInformations() {
		return "Voiture avec moteur " + this.moteur.getManufacturer();
	}
}
