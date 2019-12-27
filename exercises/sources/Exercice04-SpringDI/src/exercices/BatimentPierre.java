package exercices;

public class BatimentPierre implements Batiment {
	private int superficie;
	private int nombreDePieces;

	public BatimentPierre(int superficie, int nombreDePieces) {
		this.superficie = superficie;
		this.nombreDePieces = nombreDePieces;
	}

	@Override
	public String affiche() {
		return "batiment avec " + this.nombreDePieces + " pièces et une superficie de " + this.superficie + "m2";
	}

	@Override
	public String composition() {
		return "pierre";
	}
}
