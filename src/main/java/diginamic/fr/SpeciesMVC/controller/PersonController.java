package diginamic.fr.SpeciesMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import diginamic.fr.SpeciesMVC.model.Person;
import diginamic.fr.SpeciesMVC.repository.PersonRepository;

@Controller
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	

	/**
	 * 
	 * affiche la vue de la liste des person
	 
	 */
	
	@GetMapping("person")
	public String getPersonList(Model model) {
		List<Person> allPersons = (List<Person>) personRepository.findAll();
		model.addAttribute("persons", allPersons);
		return "list_person";
	}
	
	
	/**
	 * 
	 * @param id de person dans la BDD
	 *affiche la vue de l'objet person demandé
	
	 */
	
	@GetMapping("person/{id}")
	public String getPersonbyId(@PathVariable("id") Integer id, Model model) {
		Optional<Person> person = personRepository.findById(id);
		if(person.isPresent()) {
		model.addAttribute("person", person.get());
		return "detail_person";
		}
		return "erreur";
	}
	
	/**
	 * 
	 * Retourne la vue création de la personne
	 * On y place un objet Person vide qui sera remplie par l'utilisateur
	 */
	
	@GetMapping("person/create")
	public String getPersonCreate(Model model) {
		model.addAttribute("persons", new Person());
		return "create_person";
	}
	
}
