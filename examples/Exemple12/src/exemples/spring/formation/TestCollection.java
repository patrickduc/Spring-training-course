package exemples.spring.formation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollection {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("liste_elements.xml");

		CollectionBean listeDElements = (CollectionBean) context.getBean(CollectionBean.class);

		listeDElements.affiche();

		context.close();
	}
}
