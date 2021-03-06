package com.gabriel.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "Skill")
public class Skill {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_skill;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "beschreibung")
	private String beschreibung;
	
	@Column(name = "level")
	private String level;
	
	@Column(name = "image")
	private String image;
	
	 @ManyToMany(mappedBy = "skill")
    private Set<Mitarbeiter> mitarbeiters;
	

	public Long getId_skill() {
		return id_skill;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setId_skill(Long id_skill) {
		this.id_skill = id_skill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}


	/*public Set<Mitarbeiter> getMitarbeiters() {
		return mitarbeiters;
	}

	public void setMitarbeiters(Set<Mitarbeiter> mitarbeiters) {
		this.mitarbeiters = mitarbeiters;
	}*/


	
	
}
