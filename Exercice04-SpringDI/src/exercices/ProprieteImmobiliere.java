package exercices;

public class ProprieteImmobiliere {
	private Batiment batiment;
	private Terrain terrain;
	private String adresse;

	public ProprieteImmobiliere(String adresse) {
		this.adresse = adresse;
	}

	public void affiche() {
		System.out.println("Propriete immobiliere a l'adresse " + this.adresse + " : batiment en " + batiment.composition() + " et " + batiment.affiche() + ", terrain recouvert par " + terrain.recouvertPar() + " et " + terrain.affiche());
	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
}
