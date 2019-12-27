package exercices;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControleurSalut {

	@RequestMapping("/hello/{nom}")
	public ModelAndView disBonjourAuMonsieur(@PathVariable(value="nom") String nom, @RequestParam(name="prénom", required = true) String prenom) {
		ModelAndView resultat = new ModelAndView("salut2");
		resultat.addObject("prenom", prenom);
		resultat.addObject("nom", nom);
		return resultat;
	}

	@GetMapping("/hello")
	public ModelAndView disBonjour() {
		ModelAndView resultat = new ModelAndView("salut");
		return resultat;
	}
}
