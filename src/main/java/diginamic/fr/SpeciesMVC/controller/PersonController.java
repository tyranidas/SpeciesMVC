package diginamic.fr.SpeciesMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import diginamic.fr.SpeciesMVC.model.Animal;
import diginamic.fr.SpeciesMVC.model.Person;
import diginamic.fr.SpeciesMVC.model.Species;
import diginamic.fr.SpeciesMVC.repository.AnimalRepository;
import diginamic.fr.SpeciesMVC.repository.PersonRepository;
import diginamic.fr.SpeciesMVC.service.PersonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	

	
	@PostMapping()
	public Person create(@RequestBody @Valid Person personToCreate) {
		if (personToCreate.getId() != null) {
			throw new RuntimeException("L'id doit être null");
		}
		return this.personService.create(personToCreate);
	}
	@GetMapping("/{id}")
	public Person findById(@PathVariable("id") Integer id) {
		return this.personService.findById(id);
	}
	@GetMapping()
	public Page<Person> findAllSpecies(@RequestParam("pageNumber")Integer pageNumber) {
		return  this.personService.findAll(PageRequest.of(pageNumber-1, 2));
	}
	@PutMapping()
	public Person update(@RequestBody @Valid Person updatedPerson) {
		if (updatedPerson.getId() == null) {
			throw new RuntimeException("Il faut une id valide (à défaut de prétole)");
		}
		return this.personService.create(updatedPerson);
	}

	@DeleteMapping("/{id}")
	public void deleteSpecie(@PathVariable("id") Integer id) {
		this.personService.deleteSpecieById(id);
	}
	

}
