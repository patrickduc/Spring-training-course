package exercices;

public class Livre {
	private String auteur;
	private String isbn;
	private String titre;
	private int anneeDEdition;

	public Livre(String auteur, String isbn, String titre, int anneeDEdition) {
		this.auteur = auteur;
		this.isbn = isbn;
		this.titre = titre;
		this.anneeDEdition = anneeDEdition;
	}

	public String getTitre() {
		return this.titre;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public int getAnneeDEdition() {
		return this.anneeDEdition;
	}

	public String toString() {
		return "Auteur = " + this.auteur + ", ISBN = " + this.isbn + ", titre = " + this.titre + ", annee = " + this.anneeDEdition;
	}
}
