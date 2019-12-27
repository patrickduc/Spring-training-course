package exemples.spring.formation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class TestPiloteVoiture {

	private static ApplicationContext context;

	public static void main(String arguments[]) {
		context = new ClassPathXmlApplicationContext("PiloteVoiture.xml");

		PiloteVoiture piloteVoiture = (PiloteVoiture) context.getBean("piloteVoitureBean");
		System.out.println("Pilote de la voiture " + piloteVoiture.id());
	}

}
