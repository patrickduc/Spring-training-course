package exemples.spring.formation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProjet {
	@Bean
	public Moteur creeMoteur() {
		return new Moteur();
	}

	@Bean
	public Chassis creeChassis() {
		return new Chassis();
	}

	@Bean
	public PiloteVoiture creePiloteVoiture() {
		return new PiloteVoiture();
	}
}
