package exercices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:conf/moteur.properties")
public class Moteur {

	@Value("${moteur.fabriquant}")
	String fabriquant;

	@Value("${moteur.cylindree}")
	int cylindree;

	@Value("${moteur.puissance}")
	int puissance;

	public String infos() {
		return "Moteur : fabricant=" + this.fabriquant +", cylindree=" + this.cylindree + ", puissance=" + this.puissance;
	}
}
