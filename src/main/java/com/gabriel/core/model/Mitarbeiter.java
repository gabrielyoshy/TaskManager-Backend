package com.gabriel.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table; 

@Entity
@Table(name = "Mitarbeiter")
public class Mitarbeiter implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_mitarbeiter;
	
	@Column(name = "vorname")
	private String vorname;
	
	@Column(name = "nachname")
	private String nachname;
	
	@Column(name = "image")
	private String image;
	
	@ManyToMany(fetch = FetchType.EAGER)
    private Set<Skill> skill ;

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

	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Skill> getSkill() {
		return skill;
	}

	public void setSkill(Set<Skill> skill) {
		this.skill = skill;
	}


	
	
	

}
