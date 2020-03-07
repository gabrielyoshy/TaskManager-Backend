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
	
	
	private String name;
	
	
	private String beschreibung;
	
	/*@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "skills")
    private Set<Mitarbeiter> mitarbeiters = new HashSet<>();*/
	

	public Long getId_skill() {
		return id_skill;
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
