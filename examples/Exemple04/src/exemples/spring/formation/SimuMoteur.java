package exemples.spring.formation;

public class SimuMoteur implements IMoteur {
	private int numeroDeSerie;
	private String constructeur;

	public SimuMoteur(String constructeur, int numeroDeSerie) {
		this.constructeur = constructeur;
		this.numeroDeSerie = numeroDeSerie;
	}

	@Override
	public String id() {
		return this.constructeur + ", " + this.numeroDeSerie;
	}

	@Override
	public void demarrer() {
		System.out.println("Démarrage moteur.");
	}
	
	@Override
	public void arreter() {
		System.out.println("Arrêt moteur.");
	}
}
