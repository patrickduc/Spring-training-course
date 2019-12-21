package exercices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Livre {

	private String titre;
	private String auteur;
	private String categorie;
	private String isbn;

	@Autowired
	public Livre(String titre, String auteur, String categorie, String isbn) {
		this.titre = titre;
		this.auteur = auteur;
		this.categorie = categorie;
		this.isbn = isbn;
	}

	/*
	public void setTitre(String titre) {
		this.titre = titre;
	}

	//@Autowired
	public void setInfosLivre(String titre, String auteur, String categorie, String isbn) {
		this.titre = titre;
		this.auteur = auteur;
		this.categorie = categorie;
		this.isbn = isbn;
	}
	*/

	public String affiche() {
		String result = "Livre : isbn=" + this.isbn + ", titre=" + this.titre + ", auteur=" + this.auteur + ", categorie=" + this.categorie;
		return result;
	}

	/*
	public String getTitre() {
		return this.titre;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public String getIsbn() {
		return this.isbn;
	}
	*/
}
