package exercices;

import java.util.Collection;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Bibliotheque {
	Logger logger = LoggerFactory.getLogger(Bibliotheque.class);

	public class LivreNonTrouve extends Exception {
		private static final long serialVersionUID = 1L;

		public LivreNonTrouve(String message) {
			super(message);
		}
	}

	public class LivreDejaExistant extends Exception {
		private static final long serialVersionUID = 1L;

		public LivreDejaExistant(String message) {
			super(message);
		}
	}

	private HashMap<String, Livre> bibliotheque;

	public Bibliotheque() {
		this.bibliotheque = new HashMap<String, Livre>();
	}

	public Collection<Livre> lesLivres() {
		return this.bibliotheque.values();
	}

	public void ajouterLivre(Livre livre) throws LivreDejaExistant {
		if (this.bibliotheque.containsKey(livre.getIsbn())) {
			throw new LivreDejaExistant("Il y a déjà un livre avec ISBN=" + livre.getIsbn() + " !");
		}

		logger.info("Ajout du livre " + livre.getIsbn());
		this.bibliotheque.put(livre.getIsbn(), livre);
	}

	public void retirerLivre(String isbn) throws LivreNonTrouve {
		if (this.bibliotheque.containsKey(isbn) == false) {
			throw new Bibliotheque.LivreNonTrouve("Livre avec ISBN " + isbn + " non trouve !");
		}

		logger.info("Retrait du livre " + isbn);
		this.bibliotheque.remove(isbn);
	}

	public Livre trouverLivre(String isbn) throws Bibliotheque.LivreNonTrouve {
		logger.info("Recherche du livre " + isbn);

		if (this.bibliotheque.containsKey(isbn)) {
			return this.bibliotheque.get(isbn);
		}

		throw new Bibliotheque.LivreNonTrouve("Livre avec ISBN " + isbn + " non trouve !");
	}

	public void vider() {
		this.bibliotheque.clear();
	}

	public int nombreDeLivres() {
		return bibliotheque.size(); 		
	}
}
