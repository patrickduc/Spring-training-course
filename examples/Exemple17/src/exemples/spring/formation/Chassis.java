package exemples.spring.formation;

import org.springframework.beans.factory.annotation.Value;

public class Chassis {
	@Value("Lotus")
	public String manufacturer;

	@Value("Exige 240 R")
	public String model;

	public String id() {
		return "manufacturer=<" + this.manufacturer + ">, model=<" + this.model + ">";
	}
}
