package exercices;

public class PromoteurImmobilier {

	public static Batiment creeBatiment(int superficie, int nombreDePieces) {
		return new Batiment(superficie, nombreDePieces);
	}

	public static Terrain creeTerrain(int superficie) {
		return new Terrain(superficie);
	}

	public static ProprieteImmobiliere creeProprieteImmobiliere(String adresse) {
		return new ProprieteImmobiliere(adresse);
	}
}
