package exemples.spring.formation;

import org.springframework.beans.factory.annotation.Value;

public class Moteur {
	@Value("${manufacturer}")
	public String manufacturer;

	@Value("${power}")
	public String power;

	public String id() {
		return "manufacturer=<" + this.manufacturer + ">, power=<" + this.power + ">";
	}
}
