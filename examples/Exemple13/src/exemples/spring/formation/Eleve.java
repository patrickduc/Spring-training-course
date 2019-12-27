package exemples.spring.formation;

//import org.springframework.stereotype.Component;

//@Component
public class Eleve {

	private String nom;

	public Eleve(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return this.nom;
	}
	
}
