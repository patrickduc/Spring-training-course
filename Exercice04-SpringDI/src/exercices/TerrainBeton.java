package exercices;

public class TerrainBeton implements Terrain {

	private int superficie;

	public TerrainBeton(int superficie) {
		this.superficie = superficie;
	}

	@Override
	public String affiche() {
		return "terrain avec une superficie de " + this.superficie + "m2";
	}

	@Override
	public String recouvertPar() {
		return "beton";
	}

}
