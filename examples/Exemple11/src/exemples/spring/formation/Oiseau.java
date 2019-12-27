package exemples.spring.formation;

import org.springframework.stereotype.Component;

@Component
public class Oiseau {

	private String nom;

	public Oiseau(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return this.nom;
	}

}
