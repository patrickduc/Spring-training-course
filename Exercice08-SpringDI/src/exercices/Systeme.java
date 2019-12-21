package exercices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("config.txt")
public class Systeme {

	@Value("${java.class.path}")
	String classPath;

	@Value("${username}")
	String userName;

	@Value("${java_home}")
	String javaHome;

	@Value("${ma.valeur}")
	String maValeur;

	//@Value("${ma.valeur.inconnue:une valeur par défaut}")
	@Value("${ma.valeur.inconnue}")
	String maValeurInconnue;

	public String getClassPath() {
		return this.classPath;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getJavaHome() {
		return this.javaHome;
	}

	public String getMaValeur() {
		return this.maValeur;
	}

	public String getMaValeurInconnue() {
		return this.maValeurInconnue;
	}
}
