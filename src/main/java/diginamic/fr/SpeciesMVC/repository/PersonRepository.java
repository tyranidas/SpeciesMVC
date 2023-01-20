package diginamic.fr.SpeciesMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.fr.SpeciesMVC.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	
	
		
	
}
