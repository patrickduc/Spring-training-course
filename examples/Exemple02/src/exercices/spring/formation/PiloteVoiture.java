package exercices.spring.formation;

public class PiloteVoiture {
	private Chassis chassis;
	private Moteur unMoteur;
	private Moteur unAutreMoteur;

	public PiloteVoiture(Chassis chassis, Moteur unMoteur, Moteur unAutreMoteur) {
		this.chassis = chassis;
		this.unMoteur = unMoteur;
		this.unAutreMoteur = unAutreMoteur;
	}

	/*
	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	public void setChassis(Chassis chassis) {
		this.chassis = chassis;
	}
	*/

	public String id() {
		return "Chassis : " + chassis.id() + ", unMoteur : " + unMoteur.id() + ", unAutreMoteur : " + unAutreMoteur.id();
	}
}
