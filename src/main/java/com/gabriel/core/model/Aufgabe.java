package com.gabriel.core.model;




import java.util.Date;

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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Aufgabe")
public class Aufgabe {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_aufgabe;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "beschreibung" , columnDefinition = "LONGBLOB")
	private String beschreibung;
	
	@Column(name = "geschatzter_aufwand")
	private int  geschatzter_aufwand;
	
	@Column(name = "beginnt")
	private Date beginnt = new Date();
	
	@Column(name = "endet ")
	private Date endet  = new Date();
	
	///Die Aufgaben können nur ein Skill haben
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_skill")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id_skill")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("skill")
    private Skill skill;
	
	//Die Aufgaben können nur ein Projekt haben
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_projekt", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id_projekt")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("projekt")
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

	public Date getBeginnt() {
		return beginnt;
	}

	public void setBeginnt(Date beginnt) {
		this.beginnt = beginnt;
	}

	public Date getEndet() {
		return endet;
	}

	public void setEndet(Date endet) {
		this.endet = endet;
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
