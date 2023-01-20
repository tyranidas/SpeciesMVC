package diginamic.fr.SpeciesMVC.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50)
	@NotEmpty
	@Size(max = 50)
	private String color;
	
	@Column(length = 50)
	@NotEmpty
	@Size(max = 50)
	private String name;
	
	@Column(length = 50)
	@NotEmpty
	@Size(max = 255)
	private String sex;
	
	@ManyToOne
	@JoinColumn(name = "species_id")   
	private Species species;
	
	@ManyToMany(mappedBy = "animals")
	@JsonIgnoreProperties("animals")
	private List<Person> prop = new ArrayList<>();

	public Integer getId() {
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
