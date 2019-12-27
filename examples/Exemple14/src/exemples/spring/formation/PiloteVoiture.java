package exemples.spring.formation;

public class PiloteVoiture {
	private Chassis chassis;
	private Moteur moteur;

	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	public void setChassis(Chassis chassis) {
		this.chassis = chassis;
	}

	public String id() {
		return "Chassis : " + chassis.id() + ", moteur : " + moteur.id();
	}
}
