package diginamic.fr.SpeciesMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import diginamic.fr.SpeciesMVC.model.Animal;
import diginamic.fr.SpeciesMVC.model.Species;
import diginamic.fr.SpeciesMVC.repository.AnimalRepository;
import diginamic.fr.SpeciesMVC.repository.SpeciesRepository;

@Controller
public class SpeciesController {
	@Autowired
	private SpeciesRepository speciesRepository;
	
	@GetMapping("specie")
	public String getPersonList(Model model) {
		List<Species> allSpecies = (List<Species>) speciesRepository.findAll();
		System.out.println(allSpecies.get(0).getCommunName());
		model.addAttribute("species", allSpecies);
		return "list_species";
	}
	
	@GetMapping("specie/{id}")
	public String getPersonbyId(@PathVariable("id") Integer id, Model model) {
		Optional<Species> species = speciesRepository.findById(id);
		if(species.isPresent()) {
		model.addAttribute("species", species.get());
		return "detail_species";
		}
		return "erreur";
	}
	
	@GetMapping("specie/create")
	public String getPersonCreate(Model model) {
		model.addAttribute("species", new Animal());
		return "create_specie";
	}
	
}
