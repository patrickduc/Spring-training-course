package exercices.springrest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
//import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
//import org.springframework.hateoas.CollectionModel;


@RestController
class EmployeeController {

  private final EmployeRepository repository;

  EmployeeController(EmployeRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

  @GetMapping("/employees")
  List<Employe> all() {
    return repository.findAll();
  }

  @PostMapping("/employees")
  //@ResponseStatus(code = HttpStatus.CREATED)
  ResponseEntity<Employe> newEmployee(@RequestBody Employe newEmployee, HttpServletRequest requete) throws URISyntaxException {
	  Employe employe = repository.save(newEmployee);

	  String urlRequete = requete.getRequestURL().toString();
	  URI location = new URI(urlRequete + "/" + employe.getId());
	  //HttpHeaders responseheaders = new HttpHeaders();
	  //responseheaders.se
	  return ResponseEntity.created(location).header("MyResponseHeader", "MyValue").body(employe);
  }

  // Single item

  @GetMapping("/employees/{id}")
  EntityModel<Employe> one(@PathVariable Long id) {

    Employe employe = repository.findById(id)
      .orElseThrow(() -> new EmployeNotFoundException(id));

    EntityModel<Employe> modele = new EntityModel<>(employe);
   
    Link link = WebMvcLinkBuilder.linkTo(EmployeeController.class).withRel("root");
    modele.add(link);

    link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).one(id)).withSelfRel();
    modele.add(link);

    link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).all()).withRel("all");
    modele.add(link);

    return modele;
  }

  @PutMapping("/employees/{id}")
  Employe replaceEmployee(@RequestBody Employe newEmployee, @PathVariable Long id) {

    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}