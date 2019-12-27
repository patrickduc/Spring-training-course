package exemples.spring.formation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQualifier {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cage.xml", "oiseaux.xml");

		Cage cage = (Cage) context.getBean(Cage.class);

		System.out.println(cage.affiche());

		context.close();
	}
}
