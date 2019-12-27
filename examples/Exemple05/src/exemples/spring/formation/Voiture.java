package exemples.spring.formation;

import org.springframework.stereotype.Component;

@Component("voiture")
public class Voiture {
	public String getManufacturer() {
		return "Renault";
	}
}
