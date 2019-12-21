package exercices.springdata;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Livre {

	@Transient
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Id
	private String isbn;

	private String auteur;
	private String titre;
	private int annee;

	public Livre() {
	}

	public Livre(String auteur, String isbn, String titre, int annee) {
		this.auteur = auteur;
		this.isbn = isbn;
		this.titre = titre;
		this.annee = annee;
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

	public int getAnnee() {
		return this.annee;
	}

	public String toString() {
		return "Auteur = " + this.auteur + ", ISBN = " + this.isbn + ", titre = " + this.titre + ", annee = " + this.annee;
	}
}
