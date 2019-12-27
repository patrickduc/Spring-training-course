package exercices;

//import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class TestSysteme {

	public static void main(String arguments[]) {
		/*
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                              envName,
                              env.get(envName));
        }
        */

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("exercices");

		//Systeme systeme = (Systeme) context.getBean("leSysteme");
		Systeme systeme = (Systeme) context.getBean(Systeme.class);
		System.out.println("Classpath : " + systeme.getClassPath());
		System.out.println("User name : " + systeme.getUserName());
		System.out.println("Java HOME : " + systeme.getJavaHome());
		System.out.println("Ma valeur : " + systeme.getMaValeur());
		System.out.println("Ma valeurInconnue : " + systeme.getMaValeurInconnue());

		context.close();
	}
}
