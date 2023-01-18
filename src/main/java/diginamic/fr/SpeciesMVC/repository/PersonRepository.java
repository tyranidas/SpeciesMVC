package diginamic.fr.SpeciesMVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import diginamic.fr.SpeciesMVC.model.Person;


@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{
	List<Person> findByLastnameOrFirstname(String lastname, String firstname);
	
	
	List<Person> findByAgeGreaterThan(Integer age);
	
	@Query("from Person where age >= :minage and age <= :maxage")
	List<Person> findByAge(
			@Param("minage") Integer minAge,
			@Param("maxage") Integer maxage);
	
	@Query ("SELECT p FROM Person p INNER JOIN Animal a INNER JOIN Species s where s.commonName = :name")
	List<Person> findByCommunName(@Param("name") String name);
	
	
		
	
}
