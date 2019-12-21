package exercices;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Exercice03SpringMvcApplicationTests {

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
	}

	@Test
	void ajouterLivre() {
		Livre livre = new Livre("Jane Austen", "123456789", "Orgueil et préjugés", 1820);
		bibliotheque.ajouterLivre(livre);
	}

	@Test
	void retirerLivre() {
		Livre livre = new Livre("Jane Austen", "123456789", "Orgueil et préjugés", 1820);
		bibliotheque.ajouterLivre(livre);
		bibliotheque.retirerLivre("123456789");
	}

	@Test
	void lireContenuBibliotheque() {
		Livre livre = new Livre("Jane Austen", "123456789", "Orgueil et préjugés", 1820);
		bibliotheque.ajouterLivre(livre);

		for (Livre leLivre : bibliotheque.lesLivres()) {
			System.out.println("Livre : " + leLivre);
		}
	}

	@Test
	public void testerLivreInexistant() {
		assertThrows(Bibliotheque.LivreNonTrouve.class, () -> {
			bibliotheque.trouverLivre("123456789");
	    });
	}

	@Test
	public void testerLivreExistant() {
		bibliotheque.ajouterLivre(new Livre("Jane Austen", "123456789", "Orgueil et préjugés", 1820));

		assertDoesNotThrow(() -> {
			bibliotheque.trouverLivre("123456789");
	    });
	}
}
