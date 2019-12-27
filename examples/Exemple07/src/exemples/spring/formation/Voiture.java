package exemples.spring.formation;

import java.util.Optional;

import org.springframework.stereotype.Component;
import javax.inject.Inject;

@Component("voiture")
public class Voiture {

	@Inject
	private Optional<Moteur> moteur;

	public String getInformations() {
		return "Voiture avec moteur " + this.moteur.get().getManufacturer();
	}
}
