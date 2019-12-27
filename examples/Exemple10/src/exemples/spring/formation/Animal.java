package exemples.spring.formation;

import org.springframework.stereotype.Component;

@Component
public interface Animal {
	String getName();
	String makeASound();
}
