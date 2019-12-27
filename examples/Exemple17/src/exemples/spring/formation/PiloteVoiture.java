package exemples.spring.formation;

import org.springframework.beans.factory.annotation.Autowired;

public class PiloteVoiture {

	// L'annotation @Autowired peut etre placee sur les propri�t�s ou sur les setters de propri�t�.
	// On peut se passer des setters si on place l'annotation directement sur les propri�t�s.

	//@Autowired
	private Chassis chassis;

	//@Autowired
	private Moteur moteur;

	@Autowired
	public void setChassis(Chassis chassis) {
		this.chassis = chassis;
	}

	@Autowired
	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	public String id() {
		return "Chassis : " + chassis.id() + ", moteur : " + moteur.id() + ".";
	}
}
