package diginamic.fr.SpeciesMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.fr.SpeciesMVC.model.Animal;


@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	
}