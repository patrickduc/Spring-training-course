package exercices.springdata;

import java.util.List;

@FunctionalInterface
public interface ChercheLivres {
	List<Livre> cherche(String isbn, String auteur, String titre, int annee);
}
