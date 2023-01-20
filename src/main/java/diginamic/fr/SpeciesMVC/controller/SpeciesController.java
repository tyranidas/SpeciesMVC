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

import diginamic.fr.SpeciesMVC.model.Species;
import diginamic.fr.SpeciesMVC.service.SpeciesService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/species")
public class SpeciesController {
	@Autowired
	private SpeciesService speciesService;
	
	@PostMapping()
	public Species create(@RequestBody @Valid Species specieToCreate) {
		if (specieToCreate.getId() != null) {
			throw new RuntimeException("blabla");
		}
		return this.speciesService.create(specieToCreate);
	}
	@GetMapping("/{id}")
	public Species findById(@PathVariable("id") Integer id) {
		return this.speciesService.findById(id);
	}
	@GetMapping()
	public Page<Species> findAllSpecies(@RequestParam("pageNumber")Integer pageNumber) {
		return  this.speciesService.findAll(PageRequest.of(pageNumber-1, 2));
	}
	@PutMapping()
	public Species update(@RequestBody @Valid Species updatedSpecie) {
		if (updatedSpecie.getId() == null) {
			throw new RuntimeException("blabla");
		}
		return this.speciesService.create(updatedSpecie);
	}

	@DeleteMapping("/{id}")
	public void deleteSpecie(Integer id) {
		this.speciesService.deleteSpecieById(id);
	}
	
}
