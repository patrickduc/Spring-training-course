package exercices.spring.formation;

public class Moteur {
	public String id() {
		return "Toyota 1.8 litre VVTLI";
	}

	public void demarrer() {
		System.out.println("D�marrage moteur.");
	}
	
	public void arreter() {
		System.out.println("Arr�t moteur.");
	}
}
