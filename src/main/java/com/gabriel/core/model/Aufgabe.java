package com.gabriel.core.model;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Aufgabe")
public class Aufgabe {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_aufgabe;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "beschreibung")
	private String beschreibung;
	
	@Column(name = "geschatzter_aufwand")
	private int  geschatzter_aufwand;
	
	//Die Aufgaben können nur ein Skill haben
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Skill.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_skill")
    private Skill skill;
	
	//Die Aufgaben können nur ein Projekt haben
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Projekt.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_projekt")
	private Projekt projekt; 
	
	public Long getId_aufgabe() {
		return id_aufgabe;
	}

	public void setId_aufgabe(Long id_aufgabe) {
		this.id_aufgabe = id_aufgabe;
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

	public int getGeschatzter_aufwand() {
		return geschatzter_aufwand;
	}

	public void setGeschatzter_aufwand(int geschatzter_aufwand) {
		this.geschatzter_aufwand = geschatzter_aufwand;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Projekt getProjekt() {
		return projekt;
	}

	public void setProjekt(Projekt projekt) {
		this.projekt = projekt;
	}


}
