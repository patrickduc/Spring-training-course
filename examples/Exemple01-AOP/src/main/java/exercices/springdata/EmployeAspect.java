package exercices.springdata;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class EmployeAspect {

	@Aspect
	public class EmployeeAspect {

		@Before("execution(public String getName())")
		public void getNameAdvice(){
			System.out.println("Executing Advice on getName()");
		}
		
		@Before("execution(* exercices.springdata.*.get*())")
		public void getAllAdvice(){
			System.out.println("Service method getter called");
		}
	}
}
