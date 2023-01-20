package diginamic.fr.SpeciesMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import diginamic.fr.SpeciesMVC.model.Animal;
import diginamic.fr.SpeciesMVC.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class AnimalService {
	@Autowired
	private AnimalRepository animalRepository;

	public Animal create(@Valid Animal animalToCreate) {
		if (animalToCreate.getId() != null) {
			throw new RuntimeException("blabla");
		}
		return this.animalRepository.save(animalToCreate);
	}

	public Animal update(@Valid Animal updatedAnimal) {
		if (updatedAnimal.getId() == null) {
			throw new RuntimeException("blabla");
		}
		return this.animalRepository.save(updatedAnimal);
	}

	public Page<Animal> findAll(Pageable pageable) {
		return  this.animalRepository.findAll(pageable);
	}

	public Animal findById(@Valid Integer id) {
		return this.animalRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public void deleteAnimalbyId(Integer id) {
		this.animalRepository.deleteById(id);
	}

}
