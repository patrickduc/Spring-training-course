package exercices;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import exercices.Bibliotheque.LivreDejaExistant;
import exercices.Bibliotheque.LivreNonTrouve;

@Controller
public class ControleurBibliotheque {

	Logger logger = LoggerFactory.getLogger(ControleurBibliotheque.class);

	@ResponseStatus(code = HttpStatus.GATEWAY_TIMEOUT, reason = "Pasque !")
	public class ErreurInattendue extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public ErreurInattendue(String message) {
			super(message);
		}
	}

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
			@RequestParam(name = "annee", required = true) int anneeDEdition, HttpServletRequest requete) throws LivreDejaExistant, ErreurInattendue, RuntimeException {
		logger.info("La bibliotheque " + bibliotheque + " contient " + bibliotheque.nombreDeLivres() + " livres.");

		/* Pour tester les erreurs internes au serveur
		if (isbn.equals("123")) {
			throw new ErreurInattendue("Gniark gniark gniark !");
		}
		*/
		ModelAndView modele = new ModelAndView("ok");

		if (isbn.equals("123")) {
			/*
			String message = "Ce numéro ISBN est interdit !!";
			logger.error(message);

			logger.info((String) requete.getAttribute("javax.servlet.error.status_code"));

			modele.setViewName("error");
			modele.addObject("codeHttp", requete.getAttribute("javax.servlet.error.status_code"));
			modele.addObject("message", message);
			return modele;
			*/
			logger.info("Levée d'une exception !");
			throw new ErreurInattendue("Numéro ISBN interdit !");
			//throw new RuntimeException("Numéro ISBN interdit !");
		}

		Livre livre = new Livre(auteur, isbn, titre, anneeDEdition);
		logger.info("Ajout du livre " + livre);
		bibliotheque.ajouterLivre(livre);

		modele.addObject("nombre", bibliotheque.nombreDeLivres());

		return modele;
	}

	@GetMapping("/biblio/chercher")
	public String chercherLivre(@RequestParam(name = "isbn", required = true) String isbn, Model modele) throws LivreNonTrouve {
		logger.info("La bibliotheque " + bibliotheque + " contient " + bibliotheque.nombreDeLivres() + " livres.");
		logger.info("Recherche du livre avec ISBN=" + isbn);

		Livre livre = bibliotheque.trouverLivre(isbn);
		logger.error("Le livre avec ISBN=" + isbn + " existe dans la bibliotheque.");
		modele.addAttribute("livre", livre);

		return "affichage_livre";
	}

	@GetMapping("/biblio/retirer")
	public String retirerLivre(@RequestParam(name = "isbn", required = true) String isbn, Model modele) throws LivreNonTrouve {
		logger.info("La bibliotheque " + bibliotheque + " contient " + bibliotheque.nombreDeLivres() + " livres.");
		logger.info("Retrait du livre avec ISBN=" + isbn);

		bibliotheque.retirerLivre(isbn);
		logger.error("Le livre avec ISBN=" + isbn + " a été retiré de la bibliotheque.");
		modele.addAttribute("isbn", isbn);

		return "retrait_livre";
	}

	/*
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView gestionErreurs(HttpServletRequest requete) {
		logger.info("Entree dans la méthode de gestion des erreurs");

		ModelAndView modele = new ModelAndView("error");

		int httpErrorCode = this.getErrorCode(requete);
		modele.addObject("httpCode", httpErrorCode);

		return modele;
	}

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
    }
    */
}
