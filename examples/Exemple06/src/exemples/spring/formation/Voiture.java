package exemples.spring.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("voiture")
public class Voiture {

	@Autowired(required = false)
	private Moteur moteur;

	public String getInformations() {
		return "Voiture avec moteur " + this.moteur.getManufacturer();
	}
}
