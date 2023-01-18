package diginamic.fr.SpeciesMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import diginamic.fr.SpeciesMVC.model.Animal;
import diginamic.fr.SpeciesMVC.model.Species;


@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer>{
	List<Animal> findAllBySpecies (Species species);
	List<Animal> findAllByColorIn (List<String> color);
	
	@Query("SELECT COUNT(a) from Animal a where a.sex = :sex ")
	Integer countBySex (@Param("sex") String sex);
	
	@Query(value = "SELECT IF((SELECT COUNT(*) "
			+ "           FROM person as p "
			+ "           INNER JOIN person_animals as p_a ON  p.id = p_a.person_id "
			+ "           INNER JOIN animal as a ON a.id = p_a.animals_id "
			+ "           INNER JOIN species as s  ON s.id = a.species_id WHERE s.common_name = :name)>0,"
			+ "        'TRUE', 'FALSE')", nativeQuery = true )
	Boolean countByCommunName(@Param("name") String name);
}