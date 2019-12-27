package exemples.spring.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("cage")
public class Cage {

	private Oiseau oiseau;

	@Autowired
	public void setOiseau(@Qualifier("oiseau3") Oiseau oiseau) {
		this.oiseau = oiseau;
	}

	public String affiche() {
		return "L'oiseau est " + this.oiseau.getNom();
	}
}
