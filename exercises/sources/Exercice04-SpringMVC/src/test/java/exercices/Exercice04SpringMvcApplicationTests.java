package exercices;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import exercices.Bibliotheque.LivreDejaExistant;
import exercices.Bibliotheque.LivreNonTrouve;

@SpringBootTest
class Exercice04SpringMvcApplicationTests {

	Logger logger = LoggerFactory.getLogger(ControleurBibliotheque.class);

	private static Bibliotheque bibliotheque;

	@BeforeAll
	static void initialiser() {
		bibliotheque = new Bibliotheque();
	}

	@BeforeEach
	void viderBibliotheque() {
		bibliotheque.vider();
	}

	@Test
	void contextLoads() {
		logger.info("Entrée (et sortie) dans/de contextLoads...");
	}

	@Test
	void ajouterLivre() throws LivreDejaExistant {
		logger.info("Test ajouterLivre...");

		Livre livre = new Livre("Jane Austen", "123456789", "Orgueil et préjugés", 1820);
		bibliotheque.ajouterLivre(livre);
	}

	@Test
	void ajouterRetirerLivre() throws LivreDejaExistant, LivreNonTrouve {
		logger.info("Test retirerLivre...");

		Livre livre = new Livre("Jane Austen", "123456789", "Orgueil et préjugés", 1820);
		bibliotheque.ajouterLivre(livre);
		bibliotheque.retirerLivre("123456789");
	}

	@Test
	void retirerLivreInexistant() throws LivreNonTrouve {
		logger.info("Test retirerLivre...");

		assertThrows(Bibliotheque.LivreNonTrouve.class, () -> {
			bibliotheque.retirerLivre("123456789");
	    });
	}

	@Test
	void lireContenuBibliotheque() throws LivreDejaExistant {
		logger.info("Test lireContenuBibliotheque...");

		Livre livre = new Livre("Jane Austen", "123456789", "Orgueil et préjugés", 1820);
		bibliotheque.ajouterLivre(livre);

		for (Livre leLivre : bibliotheque.lesLivres()) {
			System.out.println("Livre : " + leLivre);
		}
	}

	@Test
	public void testerLivreInexistant() {
		logger.info("Test testerLivreInexistant...");

		assertThrows(Bibliotheque.LivreNonTrouve.class, () -> {
			bibliotheque.trouverLivre("123456789");
	    });
	}

	@Test
	public void testerLivreExistant() throws LivreDejaExistant {
		logger.info("Test testerLivreExistant...");

		bibliotheque.ajouterLivre(new Livre("Jane Austen", "123456789", "Orgueil et préjugés", 1820));

		assertDoesNotThrow(() -> {
			bibliotheque.trouverLivre("123456789");
	    });
	}
}
