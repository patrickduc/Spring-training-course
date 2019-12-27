package exercices.spring.formation;

public class PiloteVoiture {
	private Chassis chassis;
	private Moteur moteur;

	public PiloteVoiture(Chassis chassis, Moteur moteur) {
		this.chassis = chassis;
		this.moteur = moteur;
	}

	public String id() {
		return "Chassis : " + chassis.id() + ", unMoteur : " + moteur.id();
	}
}
