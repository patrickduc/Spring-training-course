package exercices;

public class Batiment {
	private int superficie;
	private int nombreDePieces;

	public Batiment(int superficie, int nombreDePieces) {
		this.superficie = superficie;
		this.nombreDePieces = nombreDePieces;
	}

	public String affiche() {
		return "batiment avec " + this.nombreDePieces + " pièces et une superficie de " + this.superficie + "m2";
	}
}
