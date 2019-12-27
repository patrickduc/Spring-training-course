package exemples.spring.formation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("config.txt")
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
