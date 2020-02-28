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
@Table(name = "Mitarbeiter")
public class Mitarbeiter {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_mitarbeiter;
	
	@Column(name = "vorname")
	private String vorname;
	
	@Column(name = "nachname")
	private String nachname;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Skill.class)
    private List<Skill> skills = new ArrayList<>();

	public Long getId_mitarbeiter() {
		return id_mitarbeiter;
	}

	public void setId_mitarbeiter(Long id_mitarbeiter) {
		this.id_mitarbeiter = id_mitarbeiter;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public List<Skill> getSkill() {
		return skills;
	}

	public void setSkill(List<Skill> skills) {
		this.skills = skills;
	}
	
	

}
