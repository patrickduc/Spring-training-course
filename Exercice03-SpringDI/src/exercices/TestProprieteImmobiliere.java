package exercices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProprieteImmobiliere {

	private static ApplicationContext context;

	public static void main(String[] arguments) {
		context = new ClassPathXmlApplicationContext("ProprieteImmobiliere.xml");
		ProprieteImmobiliere propriete = (ProprieteImmobiliere) context.getBean("proprieteImmobiliereBean");
		propriete.affiche();
	}
}
