package diginamic.fr.SpeciesMVC.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="species")
@Component
public class Species {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "common_name",columnDefinition = "varchar(50)")
	private String commonName;
	
	@Column(name = "latin_name",columnDefinition = "varchar(200)")
	private String latinName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommunName() {
		return commonName;
	}

	public void setCommunName(String common_name) {
		this.commonName = common_name;
	}

	public String getLatinName() {
		return latinName;
	}

	public void setLatinName(String latin_name) {
		this.latinName = latin_name;
	}

	@Override
	public String toString() {
		return "Species [common_name=" + commonName + ", latin_name=" + latinName + "]";
	}
	
}
