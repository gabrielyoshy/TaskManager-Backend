package com.gabriel.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
	
	@ManyToMany(cascade = CascadeType.ALL, targetEntity = Mitarbeiter.class, fetch = FetchType.LAZY, mappedBy = "skills")
    private List<Mitarbeiter> mitarbeiter = new ArrayList<>();
	

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

	public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(List<Mitarbeiter> mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}
	
	
	
}
