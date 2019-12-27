package exercices;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class Bibliotheque {

	public class LivreNonTrouve extends Exception {
		private static final long serialVersionUID = 1L;

		public LivreNonTrouve(String message) {
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

	public void ajouterLivre(Livre livre) {
		System.out.println("Ajout du livre " + livre);
		this.bibliotheque.put(livre.getIsbn(), livre);
	}

	public void retirerLivre(String isbn) {
		if (this.bibliotheque.containsKey(isbn)) {
			this.bibliotheque.remove(isbn);
		}
	}

	public Livre trouverLivre(String isbn) throws Bibliotheque.LivreNonTrouve {
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
