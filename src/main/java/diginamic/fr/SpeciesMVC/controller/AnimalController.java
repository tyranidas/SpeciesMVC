package diginamic.fr.SpeciesMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import diginamic.fr.SpeciesMVC.model.Animal;
import diginamic.fr.SpeciesMVC.model.Person;
import diginamic.fr.SpeciesMVC.model.Species;
import diginamic.fr.SpeciesMVC.repository.AnimalRepository;
import diginamic.fr.SpeciesMVC.repository.PersonRepository;
import diginamic.fr.SpeciesMVC.repository.SpeciesRepository;

@Controller
public class AnimalController {
	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private SpeciesRepository speciesRepository;
	/**
	 * 
	 * affiche la vue de la liste des animaux
	 
	 */
	
	@GetMapping("animal")
	public String getPersonList(Model model) {
		List<Animal> allAnimals = (List<Animal>) animalRepository.findAll();
		model.addAttribute("animals", allAnimals);
		return "list_animals";
	}
	
	/**
	 * 
	 * @param id de l'animal dans la BDD
	 *affiche la vue de l'objet animal demandé
	
	 */
	
	@GetMapping("animal/{id}")
	public String getPersonbyId(@PathVariable("id") Integer id, Model model) {
		Optional<Animal> animal = animalRepository.findById(id);
		if(animal.isPresent()) {
		model.addAttribute("animal", animal.get());
		List<Species> listSpe = (List<Species>) speciesRepository.findAll();
		model.addAttribute("species", listSpe);
		return "detail_animal";
		}
		return "erreur";
	}
	
	/**
	 * 
	 * Retourne la vue création d'animal
	 * On y place un objet Animal vide qui sera remplie par l'utilisateur
	 */
	
	@GetMapping("animal/create")
	public String getPersonCreate(Model model) {
		model.addAttribute("animals", new Animal());
		List<Species> listSpe = (List<Species>) speciesRepository.findAll();
		model.addAttribute("species", listSpe);
		
		return "create_animal";
	}
	
	@PostMapping("/animal")
	public String createOrUpdate(Animal animal) {
		
	this.animalRepository.save(animal);
	return "redirect:/animal";
	}
	
	@GetMapping("/animal/delete/{id}")
	public String delete(@PathVariable("id") Integer animalId) {
	Optional<Animal> animalToDelete = this.animalRepository.findById(animalId);
	animalToDelete.ifPresent(animal -> this.animalRepository.delete(animal));
	return "redirect:/animal";
	}
	
}
