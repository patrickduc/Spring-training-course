package exercices.spring.formation;

public class Moteur {
	private int numeroDeSerie;
	private String constructeur;

	public String id() {
		return this.constructeur + ", " + this.numeroDeSerie;
	}

	public Moteur(String constructeur, int numeroDeSerie) {
		this.constructeur = constructeur;
		this.numeroDeSerie = numeroDeSerie;
	}

	public void demarrer() {
		System.out.println("D�marrage moteur.");
	}
	
	public void arreter() {
		System.out.println("Arr�t moteur.");
	}
}
