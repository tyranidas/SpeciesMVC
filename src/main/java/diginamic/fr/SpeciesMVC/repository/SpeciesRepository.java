package diginamic.fr.SpeciesMVC.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import diginamic.fr.SpeciesMVC.model.Species;


@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
	
}
