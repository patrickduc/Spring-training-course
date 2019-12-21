package exercices.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bibliotheque extends JpaRepository<Livre, String> {
	List<Livre> findByIsbn(String isbn);
	List<Livre> findByAuteur(String auteur);
	List<Livre> findByTitre(String titre);
	List<Livre> findByAnnee(Integer annee);
	List<Livre> findByIsbnAndAuteur(String isbn, String auteur);
	List<Livre> findByIsbnAndTitre(String isbn, String titre);
	List<Livre> findByIsbnAndAnnee(String isbn, Integer annee);
	List<Livre> findByAuteurAndTitre(String auteur, String titre);
	List<Livre> findByAuteurAndAnnee(String auteur, Integer annee);
	List<Livre> findByTitreAndAnnee(String titre, Integer annee);
	List<Livre> findByIsbnAndAuteurAndTitre(String isbn, String auteur, String titre);
	List<Livre> findByIsbnAndAuteurAndAnnee(String isbn, String auteur, Integer annee);
	List<Livre> findByIsbnAndTitreAndAnnee(String isbn, String titre, Integer annee);
	List<Livre> findByAuteurAndTitreAndAnnee(String auteur, String titre, Integer annee);
	List<Livre> findByIsbnAndAuteurAndTitreAndAnnee(String isbn, String auteur, String titre, Integer annee);
}
