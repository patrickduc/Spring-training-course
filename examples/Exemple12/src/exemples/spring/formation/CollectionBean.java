package exemples.spring.formation;

import java.util.List;

public class CollectionBean {

	private List<String> elements;

	public void setElements(List<String> elements) {
		this.elements = elements;
	}

	public void affiche() {
		System.out.println(this.elements);
	}
}
