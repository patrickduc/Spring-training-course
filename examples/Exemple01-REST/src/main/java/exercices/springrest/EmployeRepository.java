package exercices.springrest;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeRepository extends JpaRepository<Employe, Long> {

}