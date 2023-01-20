package diginamic.fr.SpeciesMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import diginamic.fr.SpeciesMVC.model.Person;
import diginamic.fr.SpeciesMVC.model.Species;
import diginamic.fr.SpeciesMVC.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	public Person create(@Valid Person personToCreate) {
	return this.personRepository.save(personToCreate);
	}
	public Person update(@Valid Person updatedPerson) {
	return this.personRepository.save(updatedPerson);
	}
	public Page<Person> findAll(Pageable pageable) {
	return  this.personRepository.findAll(pageable);
	}
	public Person findById(Integer id) {
	return this.personRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	
	public void deleteSpecieById(Integer id) {
		this.personRepository.deleteById(id);
	}

}
