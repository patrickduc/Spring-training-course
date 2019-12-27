package exemples.spring.formation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollege {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("college.xml");

		College elevesDuCollege = (College) context.getBean(College.class);

		elevesDuCollege.affiche();

		context.close();
	}
}
