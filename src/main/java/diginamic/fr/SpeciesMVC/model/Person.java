package diginamic.fr.SpeciesMVC.model;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "Integer(11)")
	@Max(120)
	@Min(0)
	private Integer age;
	
	
	@Column(length = 50)
	@NotEmpty
	@Size(max = 50)
	private String firstname;
	
	@Column(length = 50)
	@NotEmpty
	@Size(max = 50)
	private String lastname;
	
	@ManyToMany
	@JoinTable( name = "person_animals",
    joinColumns = @JoinColumn( name = "person_id", referencedColumnName = "id" ),
    inverseJoinColumns = @JoinColumn( name = "animals_id", referencedColumnName = "id" ) )
	Set<Animal> animals ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
}
