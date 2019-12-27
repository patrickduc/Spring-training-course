package exemples.spring.formation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class PiloteVoiture {

	@Resource
	private Chassis chassis;

	@Resource
	private Moteur moteur;

	public String id() {
		return "chassis : " + chassis.id() + ", moteur : " + moteur.id();
	}
}
