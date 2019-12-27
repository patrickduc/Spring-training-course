package exemples.spring.formation;

public class Moteur implements IMoteur {
	private int numeroDeSerie;
	private String constructeur;

	public Moteur(String constructeur, int numeroDeSerie) {
		this.constructeur = constructeur;
		this.numeroDeSerie = numeroDeSerie;
	}

	@Override
	public String id() {
		return this.constructeur + ", " + this.numeroDeSerie;
	}

	@Override
	public void demarrer() {
		System.out.println("D�marrage moteur.");
	}

	@Override
	public void arreter() {
		System.out.println("Arr�t moteur.");
	}
}
