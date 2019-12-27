package exemples.spring.formation;

import org.springframework.stereotype.Component;

@Component
public class Chassis {
	public String id() {
		return "Lotus Exige 240 R";
	}

	public void freiner() {
		System.out.println("Freinage voiture");
	}
}
