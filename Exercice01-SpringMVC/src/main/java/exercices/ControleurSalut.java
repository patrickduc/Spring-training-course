package exercices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControleurSalut {

	@GetMapping("/hello")
	public String disBonjour() {
		return "salut";
	}
}
