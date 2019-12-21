package exercices;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSatellite {

	public static void main(String[] arguments) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("exercices");
		context.refresh();

		Satellite satellite = (Satellite) context.getBean("spot5");
		System.out.println("Contenu du satellite :\n" + satellite.affiche());

		context.close();
	}
}
