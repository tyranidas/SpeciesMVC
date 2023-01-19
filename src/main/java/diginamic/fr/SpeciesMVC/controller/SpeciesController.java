package diginamic.fr.SpeciesMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import diginamic.fr.SpeciesMVC.model.Animal;
import diginamic.fr.SpeciesMVC.model.Person;
import diginamic.fr.SpeciesMVC.model.Species;
import diginamic.fr.SpeciesMVC.repository.AnimalRepository;
import diginamic.fr.SpeciesMVC.repository.SpeciesRepository;
import jakarta.validation.Valid;

@Controller
public class SpeciesController {
	@Autowired
	private SpeciesRepository speciesRepository;
	
	@GetMapping("specie")
	public String getSpeciesList(Model model) {
		List<Species> allSpecies = (List<Species>) speciesRepository.findAll();
		System.out.println(allSpecies.get(0).getCommonName());
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
		model.addAttribute("species", new Species());
		return "create_specie";
	}
	
	@PostMapping("/specie")
	public String createOrUpdate(@Valid Species species, BindingResult result) {
		if (result.hasErrors()) {
			return "create_specie";
		}
	this.speciesRepository.save(species);
	return "redirect:/specie";
	}
	
	@GetMapping("/specie/delete/{id}")
	public String delete(@PathVariable("id") Integer specieID) {
	Optional<Species> personToDelete = this.speciesRepository.findById(specieID);
	personToDelete.ifPresent(specie -> this.speciesRepository.delete(specie));
	return "redirect:/specie";
	}
	
}
