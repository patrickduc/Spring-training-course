package exercices;

public class ProprieteImmobiliere {
	private Batiment batiment;
	private Terrain terrain;
	
	public void affiche() {
		System.out.println("Propriete immobiliere : " + batiment.affiche() + ", " + terrain.affiche());
	}

	public void setBatiment(Batiment batiment) {
		this.batiment = batiment;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
}
