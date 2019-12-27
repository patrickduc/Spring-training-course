package exercices.spring.formation;

public class FabriqueVoiture {

	public static Moteur creeMoteur(int numeroDeSerie, String constructeur) {
		return new Moteur(constructeur, numeroDeSerie);
	}
}
