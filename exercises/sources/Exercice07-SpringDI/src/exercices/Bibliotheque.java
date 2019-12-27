package exercices;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bibliotheque {

	@Autowired(required = false)
	private @Qualifier("science-fiction") Set<Livre> livresSF =  new HashSet<Livre>();

	@Autowired(required = false)
	private @Qualifier("polar") Set<Livre> polars = new HashSet<Livre>();

	@Autowired(required = false)
	private @Qualifier("histoire") Set<Livre> livresDHistoire = new HashSet<Livre>();

	@Autowired(required = false)
	private @Qualifier("philosophie")Set<Livre> essaisPhilosophiques = new HashSet<Livre>();

	public void affiche() {
		System.out.println("Livres de science-fiction :");
		this.livresSF.forEach((livre) -> System.out.println(livre.affiche()));

		System.out.println("\nLivres d'histoire :");
		this.livresDHistoire.forEach((livre) -> System.out.println(livre.affiche()));

		System.out.println("\nPolars :");
		this.polars.forEach((livre) -> System.out.println(livre.affiche()));

		System.out.println("\nEssais philosophiques :");
		this.essaisPhilosophiques.forEach((livre) -> System.out.println(livre.affiche()));
	}
}
