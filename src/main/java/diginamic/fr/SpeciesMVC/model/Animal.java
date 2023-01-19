package diginamic.fr.SpeciesMVC.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="animal")
@Component
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(columnDefinition = "varchar(50)")
	private String color;
	
	@Column(columnDefinition = "varchar(50)")
	private String name;
	
	@Column(columnDefinition = "varchar(255)")
	private String sex;
	
	@ManyToOne
	@JoinColumn(name = "species_id")   
	private Species species;
	
	@ManyToMany
	@JoinTable( name = "person_animals",
    joinColumns = @JoinColumn( name = "animals_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn( name = "person_id", referencedColumnName = "id" ) )
	private List<Person> prop = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public List<Person> getProp() {
		return prop;
	}

	public void setProp(List<Person> prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return "Animal [color=" + color + ", name=" + name + ", sex=" + sex + ", Species=" + species + "]";
	}
	
	
}
