package exemples.spring.formation;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

	private String name;

	public Dog() {
		this.name = "rintintin";
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String makeASound() {
		return "ouah ouah";
	}

}
