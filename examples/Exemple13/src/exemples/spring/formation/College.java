package exemples.spring.formation;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class College {

	private List<Eleve> garcons;
	private List<Eleve> filles;

	@Autowired
	public void setGarcons(@Qualifier("garçon") List<Eleve> eleves) {
		this.garcons = eleves;
	}

	@Autowired
	public void setFilles(@Qualifier("fille") List<Eleve> eleves) {
		this.filles = eleves;
	}

	public void affiche() {
		System.out.println("Eleves garçons dans le collège :");
		for (Eleve eleve: this.garcons) {
			System.out.println("Eleve : " + eleve.getNom());
		}
		
		System.out.println("\nEleves filles dans le collège :");
		for (Eleve eleve: this.filles) {
			System.out.println("Eleve : " + eleve.getNom());
		}
	}
}
