package com.gabriel.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Projekt")
public class Projekt implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_projekt;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "beschreibung")
	private String beschreibung;
	
	
	//viele Projekte können zum selben Kunden gehören
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_kunde", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id_kunde")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("kunde")
	private Kunde kunde;

	@Column(name = "fruheste_stardat")
	private Date fruheste_stardat = new Date();
	
	@Column(name = "spatestes_enddat")
	private Date spatestes_enddat = new Date();
	
	//ein Projekt kann viele Aufgaben haben
	@OneToMany( fetch = FetchType.EAGER)
	@JoinColumn(name="id_projekt")
    private List<Aufgabe> aufgaben;

	public Long getId_projekt() {
		return id_projekt;
	}

	public void setId_projekt(Long id_projekt) {
		this.id_projekt = id_projekt;
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

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public Date getFruheste_stardat() {
		return fruheste_stardat;
	}

	public void setFruheste_stardat(Date fruheste_stardat) {
		this.fruheste_stardat = fruheste_stardat;
	}

	public Date getSpatestes_enddat() {
		return spatestes_enddat;
	}

	public void setSpatestes_enddat(Date spatestes_enddat) {
		this.spatestes_enddat = spatestes_enddat;
	}
	/*
	public List<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	public void setAufgaben(List<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}*/
	
	
	


	
	
}
