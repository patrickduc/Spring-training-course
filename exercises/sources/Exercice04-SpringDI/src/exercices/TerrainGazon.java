package exercices;

public class TerrainGazon implements Terrain {

	private int superficie;

	public TerrainGazon(int superficie) {
		this.superficie = superficie;
	}

	@Override
	public String affiche() {
		return "terrain avec une superficie de " + this.superficie + "m2";
	}

	@Override
	public String recouvertPar() {
		return "gazon";
	}

}
