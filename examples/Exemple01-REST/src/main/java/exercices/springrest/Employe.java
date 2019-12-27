package exercices.springrest;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Employe {

	private @Id @GeneratedValue Long id;
	private String name;
	private String role;

	Employe() {
	}

	Employe(String name, String role) {
		this.name = name;
		this.role = role;
	}
}