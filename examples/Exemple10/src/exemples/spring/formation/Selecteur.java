package exemples.spring.formation;

import org.springframework.stereotype.Component;

@Component
public class Selecteur {

	private int compteur;

	public Selecteur() {
		this.compteur = 0;
	}

	public int getCompteur() {
		return this.compteur;
	}
	
	public void incrementCompteur() {
		this.compteur++;
	}
}
