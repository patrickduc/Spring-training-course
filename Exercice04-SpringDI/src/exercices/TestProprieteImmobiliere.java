package exercices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProprieteImmobiliere {

	private static ApplicationContext context;

	public static void main(String[] arguments) {
		context = new ClassPathXmlApplicationContext("ProprieteImmobiliere.xml");

		ProprieteImmobiliere propriete1 = (ProprieteImmobiliere) context.getBean("proprieteImmobiliere1Bean");
		propriete1.affiche();

		ProprieteImmobiliere propriete2 = (ProprieteImmobiliere) context.getBean("proprieteImmobiliere2Bean");
		propriete2.affiche();
	}
}
