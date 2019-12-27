package exercices;

import org.springframework.stereotype.Component;

@Component("Capitole")
public class Batiment {
	private int superficie;
	private int nombreDePieces;

	public Batiment() {
		this.superficie = 125;
		this.nombreDePieces = 6;
	}

	public String affiche() {
		return "batiment avec " + this.nombreDePieces + " pièces et une superficie de " + this.superficie + "m2";
	}

	public String composition() {
		return "brique";
	}
}
