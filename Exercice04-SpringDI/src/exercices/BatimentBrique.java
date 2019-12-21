package exercices;

public class BatimentBrique implements Batiment {
	private int superficie;
	private int nombreDePieces;

	public BatimentBrique(int superficie, int nombreDePieces) {
		this.superficie = superficie;
		this.nombreDePieces = nombreDePieces;
	}

	@Override
	public String affiche() {
		return "batiment avec " + this.nombreDePieces + " pièces et une superficie de " + this.superficie + "m2";
	}

	@Override
	public String composition() {
		return "brique";
	}
}
