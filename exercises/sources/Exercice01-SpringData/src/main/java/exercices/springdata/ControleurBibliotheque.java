package exercices.springdata;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/biblio")
public class ControleurBibliotheque {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Identifiant de recherche manquant")
	public class IdentifiantDeRechercheManquant extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public IdentifiantDeRechercheManquant(String message) {
			super(message);
		}
	}

	Logger logger = LoggerFactory.getLogger(ControleurBibliotheque.class);

	@Autowired
	Bibliotheque bibliotheque;

	@GetMapping
	public String principale(Model modele) {
		logger.info("La bibliotheque contient " + bibliotheque.count() + " livres.");
		return "ajout_livre";
	}

	@GetMapping("/decompte")
	public String decompte(Model modele) {
		logger.info("La bibliotheque contient " + bibliotheque.count() + " livres.");
		modele.addAttribute("decompte", bibliotheque.count());
		return "decompte";
	}

	@GetMapping("/lister")
	public String lister(Model modele) {
		logger.info("La bibliotheque contient " + bibliotheque.count() + " livres.");
		List<Livre> livres = bibliotheque.findAll();
		for (Livre livre : livres) {
			System.out.println("\tLivre : " + livre);
		}
		modele.addAttribute("livres", livres);
		return "liste";
	}

	@PutMapping("/ajouter")
	public ModelAndView ajouterLivre(@RequestParam(name = "isbn", required = true) String isbn,
			@RequestParam(name = "titre", required = true) String titre,
			@RequestParam(name = "auteur", required = true) String auteur,
			@RequestParam(name = "annee", required = true) int annee) {
		logger.info("La bibliotheque contient " + bibliotheque.count() + " livres.");

		Livre livre = new Livre(auteur, isbn, titre, annee);
		logger.info("Ajout du livre " + livre);
		try {
			bibliotheque.save(livre);
		}
		catch (DataAccessException e) {
			logger.error("Data access exception recue : " + e);
			logger.error("Exception originelle : " + e.getCause());
			logger.error("Exception la plus specifique : " + e.getMostSpecificCause());
			logger.error("Message associé à l'exception : " + e.getMessage());
			throw(e);
		}

		ModelAndView modele = new ModelAndView("ok");
		modele.addObject("nombre", bibliotheque.count());

		return modele;
	}

	@GetMapping("/chercher")
	public String chercherLivre(@RequestParam(name = "isbn", required = false) Optional<String> isbn,
			@RequestParam(name = "auteur", required = false) Optional<String> auteur,
			@RequestParam(name = "titre", required = false) Optional<String> titre,
			@RequestParam(name = "annee", required = false) Optional<Integer> annee,
			Model modele) {
		logger.info("La bibliotheque contient " + bibliotheque.count() + " livres.");

		List<Livre> livres = trouveLivres(isbn, auteur, titre, annee);

		if (isbn.isPresent()) {
			modele.addAttribute("isbn", isbn.get());
		}

		if (auteur.isPresent()) {
			modele.addAttribute("auteur", auteur.get());
		}

		if (titre.isPresent()) {
			modele.addAttribute("titre", titre.get());
		}

		if (annee.isPresent()) {
			modele.addAttribute("annee", annee.get());
		}

		if (livres.size() == 0) {
			return "pas_trouve";
		}

		modele.addAttribute("livres", livres);
		modele.addAttribute("nombre_de_livres", livres.size());

		return "affichage_livres";
	}

	private List<Livre> trouveLivres(Optional<String> isbn, Optional<String> auteur, Optional<String> titre, Optional<Integer> annee)
			throws IdentifiantDeRechercheManquant {
		try {
			if (isbn.isPresent()) {
				if (auteur.isPresent()) {
					if (titre.isPresent()) {
						if (annee.isPresent()) {
							return bibliotheque.findByIsbnAndAuteurAndTitreAndAnnee(isbn.get(), auteur.get(), titre.get(), annee.get());
						}
						return bibliotheque.findByIsbnAndAuteurAndTitre(isbn.get(), auteur.get(), titre.get());
					}
					else {
						if (annee.isPresent()) {
							return bibliotheque.findByIsbnAndAuteurAndAnnee(isbn.get(), auteur.get(), annee.get());
						}
						return bibliotheque.findByIsbnAndAuteur(isbn.get(), auteur.get());
					}
				}
				else {
					if (titre.isPresent()) {
						if (annee.isPresent()) {
							return bibliotheque.findByIsbnAndTitreAndAnnee(isbn.get(), titre.get(), annee.get());
						}
						return bibliotheque.findByIsbnAndTitre(isbn.get(), titre.get());
					}
					else {
						if (annee.isPresent()) {
							return bibliotheque.findByIsbnAndAnnee(isbn.get(), annee.get());
						}
						return bibliotheque.findByIsbn(isbn.get());
					}
				}
			}
			else {
				if (auteur.isPresent()) {
					if (titre.isPresent()) {
						if (annee.isPresent()) {
							return bibliotheque.findByAuteurAndTitreAndAnnee(auteur.get(), titre.get(), annee.get());
						}
						return bibliotheque.findByAuteurAndTitre(auteur.get(), titre.get());
					}
					else {
						if (annee.isPresent()) {
							return bibliotheque.findByAuteurAndAnnee(auteur.get(), annee.get());
						}
						return bibliotheque.findByAuteur(auteur.get());
					}
				}
				else {
					if (titre.isPresent()) {
						if (annee.isPresent()) {
							return bibliotheque.findByTitreAndAnnee(titre.get(), annee.get());
						}
						return bibliotheque.findByTitre(titre.get());
					}
					else {
						if (annee.isPresent()) {
							return bibliotheque.findByAnnee(annee.get());
						}
						throw new IdentifiantDeRechercheManquant("Aucun identifiant de recherche précisé !");
					}
				}
			}
		}
		catch (DataAccessException e) {
			logger.error("Data access exception recue : " + e);
			logger.error("Message : " + e.getMessage());
			logger.error("Exception d'origine : " + e.getCause());
			logger.error("Exception racine : " + e.getMostSpecificCause());
			throw(e);
		}
	}

	@DeleteMapping("/supprimer")
	public String supprimerLivre(@RequestParam(name = "isbn", required = true) String isbn, Model modele) {
		logger.info("La bibliotheque contient " + bibliotheque.count() + " livres.");

		try {
			bibliotheque.findByIsbn(isbn);
			bibliotheque.deleteById(isbn);
			modele.addAttribute("isbn", isbn);
		}
		catch (DataAccessException e) {
			logger.error("Data access exception recue : " + e);
			logger.error("Exception originelle : " + e.getCause());
			logger.error("Exception la plus specifique : " + e.getMostSpecificCause());
			logger.error("Message associé à l'exception : " + e.getMessage());
			throw(e);
		}

		return "suppression_livre";
	}
}
