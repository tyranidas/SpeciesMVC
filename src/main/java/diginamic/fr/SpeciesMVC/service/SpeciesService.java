package diginamic.fr.SpeciesMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import diginamic.fr.SpeciesMVC.model.Animal;
import diginamic.fr.SpeciesMVC.model.Person;
import diginamic.fr.SpeciesMVC.model.Species;
import diginamic.fr.SpeciesMVC.repository.PersonRepository;
import diginamic.fr.SpeciesMVC.repository.SpeciesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class SpeciesService {
	@Autowired
	SpeciesRepository speciesRepository;
	public Species create(@Valid Species specieToCreate) {
	return this.speciesRepository.save(specieToCreate);
	}
	public Species update(@Valid Species updatedSpecies) {
	return this.speciesRepository.save(updatedSpecies);
	}
	public Page<Species> findAll(Pageable pageable) {
	return  this.speciesRepository.findAll(pageable);
	}
	public Species findById(Integer id) {
	return this.speciesRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public void deleteSpecieById(Integer id) {
		this.speciesRepository.deleteById(id);
	}

}
