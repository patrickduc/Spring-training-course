package exercices.spring.formation;

public class Chassis {
	private int valeur1;
	private int valeur2;

	public Chassis(int valeur1, int valeur2) {
		this.valeur1 = valeur1;
		this.valeur2 = valeur2;
	}

	public String id() {
		return "Lotus Exige 240 R : valeur1 = " + this.valeur1 + ", valeur2 = " + this.valeur2;
	}

	public void freiner() {
		System.out.println("Freinage voiture");
	}
}
