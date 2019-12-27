package exemples.spring.formation;

import org.springframework.stereotype.Component;

@Component
public class Bird implements Animal {

	private String name;

	public Bird() {
		this.name = "titi";
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String makeASound() {
		return "piou piou";
	}

}
