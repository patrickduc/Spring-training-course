package exercices.springdata;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControleurDErreur implements ErrorController {

	Logger logger = LoggerFactory.getLogger(ControleurDErreur.class);

	@RequestMapping(value = "/error")
	public ModelAndView gere(HttpServletRequest requete) {
		logger.error("Entree dans la méthode de gestion des erreurs");
		logger.error("Status HTTP = " + requete.getAttribute("javax.servlet.error.status_code"));
		/*
		for (Enumeration<String> nomsDAttribut = requete.getAttributeNames(); nomsDAttribut.hasMoreElements();) {
			logger.error("Attribut : " + nomsDAttribut.nextElement());
		}
		*/

		ModelAndView modele = new ModelAndView("error");
		modele.addObject("codeHttp", (int) requete.getAttribute("javax.servlet.error.status_code"));

		Exception exceptionRecue = (Exception) requete.getAttribute("javax.servlet.error.exception");

		if (exceptionRecue != null) {
			modele.addObject("messageDErreur", (String) exceptionRecue.getMessage());
			logger.error("Texte de l'exception : " + exceptionRecue.toString());
			logger.error("Exception originelle : " + exceptionRecue.getCause());

			modele.addObject("texteException", exceptionRecue.getCause());
		}
		else {
			modele.addObject("messageDErreur", "Pas d'exception.");
		}

        return modele;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
