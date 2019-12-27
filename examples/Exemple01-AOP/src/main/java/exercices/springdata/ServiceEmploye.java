package exercices.springdata;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceEmploye {
	@Autowired
	private Employe employe;

	public Employe getEmployee(){
		return this.employe;
	}

	public void setEmployee(Employe e){
		this.employe = e;
	}
}
