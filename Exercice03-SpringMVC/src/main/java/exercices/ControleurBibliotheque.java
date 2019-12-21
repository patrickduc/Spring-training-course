package exercices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControleurBibliotheque {

	Logger logger = LoggerFactory.getLogger(ControleurBibliotheque.class);

	@Autowired
	Bibliotheque bibliotheque;

	@GetMapping("/biblio")
	public String principale() {
		logger.info("La bibliotheque " + bibliotheque + " contient " + bibliotheque.nombreDeLivres() + " livres.");
		return "ajout_livre";
	}

	@GetMapping("/biblio/lister")
	public String lister(Model modele) {
		logger.info("La bibliotheque " + bibliotheque + " contient " + bibliotheque.nombreDeLivres() + " livres.");
		modele.addAttribute("livres", bibliotheque.lesLivres());
		return "liste";
	}

	@GetMapping("/biblio/ajouter")
	public ModelAndView ajouterLivre(@RequestParam(name = "isbn", required = true) String isbn,
			@RequestParam(name = "titre", required = true) String titre,
			@RequestParam(name = "auteur", required = true) String auteur,
			@RequestParam(name = "annee", required = true) int anneeDEdition) {
		logger.info("La bibliotheque " + bibliotheque + " contient " + bibliotheque.nombreDeLivres() + " livres.");

		Livre livre = new Livre(auteur, isbn, titre, anneeDEdition);
		logger.info("Ajout du livre " + livre);
		bibliotheque.ajouterLivre(livre);

		ModelAndView modele = new ModelAndView("ok");
		modele.addObject("nombre", bibliotheque.nombreDeLivres());

		return modele;
	}

	@GetMapping("/biblio/chercher")
	public String chercherLivre(@RequestParam(name = "isbn", required = true) String isbn, Model modele) {
		logger.info("La bibliotheque " + bibliotheque + " contient " + bibliotheque.nombreDeLivres() + " livres.");
		logger.info("Recherche du livre avec ISBN=" + isbn);

		try {
			Livre livre = bibliotheque.trouverLivre(isbn);
			logger.error("Le livre avec ISBN=" + isbn + " existe dans la bibliotheque.");
			modele.addAttribute("livre", livre);
		}
		catch (Bibliotheque.LivreNonTrouve e) {
			logger.error("Le livre avec ISBN=" + isbn + " n'existe pas dans la bibliotheque !");
			return "livre_non_trouve";
		}

		return "affichage_livre";
	}
}
