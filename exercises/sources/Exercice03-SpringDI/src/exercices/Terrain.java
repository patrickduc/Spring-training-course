package exercices;

public class Terrain {

	private int superficie;

	public Terrain(int superficie) {
		this.superficie = superficie;
	}

	public String affiche() {
		return "terrain avec une superficie de " + this.superficie + "m2";
	}

}
