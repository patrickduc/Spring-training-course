package exercices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/conf/chassis.properties")
public class Chassis {

	@Value("${chassis.fabriquant}")
	String fabriquant;

	@Value("${chassis.modele}")
	String modele;

	@Value("${chassis.anneedefabrication}")
	int anneeDeFabrication;

	public String infos() {
		return "Chassis : fabricant=" + this.fabriquant +", modele=" + this.modele + ", annee=" + this.anneeDeFabrication;
	}
}
