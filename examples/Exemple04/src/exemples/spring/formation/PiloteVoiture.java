package exemples.spring.formation;

public class PiloteVoiture {
	private Chassis chassis;
	private IMoteur moteur;

	public PiloteVoiture(Chassis chassis, IMoteur moteur) {
		this.chassis = chassis;
		this.moteur = moteur;
	}

	public String id() {
		return "Chassis : " + chassis.id() + ", unMoteur : " + moteur.id();
	}
}
