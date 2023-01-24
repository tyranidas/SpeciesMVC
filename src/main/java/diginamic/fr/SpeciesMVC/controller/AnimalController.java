package diginamic.fr.SpeciesMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import diginamic.fr.SpeciesMVC.service.AnimalService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/animal")
public class AnimalController {
	@Autowired
	private AnimalService animalService;
	
	
	@PostMapping()
	public Animal createAnimal(@RequestBody @Valid Animal animal) {
		if (animal.getId() != null) {
			throw new RuntimeException("L'id doit être null");
		}
		return animalService.create(animal);
	}
	
	@GetMapping("/{id}")
	public Animal findAnimalbyId(@PathVariable("id") Integer id) {
		return this. animalService.findById(id);
	}
	@GetMapping()
	public Page<Animal> findAllAnimal(@RequestParam("pageNumber")Integer pageNumber) {
		return this.animalService.findAll(PageRequest.of(pageNumber-1, 2));
	}
	@PutMapping()
	public Animal updateAnimal(@RequestBody @Valid Animal animal) {
		if (animal.getId() == null) {
			throw new RuntimeException("Il faut une id valide (à défaut de pétrole)");
		}
		return this.animalService.update(animal);
	}
	@DeleteMapping("/{id}")
	public String deleteAnimal(@PathVariable("id") Integer id) {
		this.animalService.deleteAnimalbyId(id);
		return "pouet";
	}
	
	
	
}
