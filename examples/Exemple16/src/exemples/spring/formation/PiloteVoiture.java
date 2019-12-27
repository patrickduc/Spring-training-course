package exemples.spring.formation;

import org.springframework.beans.factory.annotation.Autowired;

public class PiloteVoiture {
	@Autowired
	private Chassis chassis;

	@Autowired
	private Moteur moteur;

	public String id() {
		return "Chassis : " + chassis.id() + ", moteur : " + moteur.id();
	}
}
