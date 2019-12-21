package exercices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("spot5")
public class Satellite {

	private Plateforme plateforme;
	private ChargeUtile chargeUtile;
	private PanneauSolaire panneauSolaire1;
	private PanneauSolaire panneauSolaire2;

	@Autowired
	private AntenneRadio antenneRadio;

	@Autowired
	public Satellite(Plateforme plateforme, ChargeUtile chargeUtile) {
		this.plateforme = plateforme;
		this.chargeUtile = chargeUtile;
	}

	@Autowired
	public void setPanneauxSolaires(PanneauSolaire panneauSolaire1, PanneauSolaire panneauSolaire2) {
		this.panneauSolaire1 = panneauSolaire1;
		this.panneauSolaire2 = panneauSolaire2;
	}

	public String affiche() {
		String result = "Satellite :\n\tplateforme=" + this.plateforme.getId() + "\n\tcharge utile=" + this.chargeUtile.getId()
		+ "\n\tpanneau solaire 1=" + this.panneauSolaire1.getId() + "\n\tpanneau solaire 2=" + this.panneauSolaire2.getId()
		+ "\n\tantenne radio=" + this.antenneRadio.getId();

		return result;
	}
}
