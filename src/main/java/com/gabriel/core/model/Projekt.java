package com.gabriel.core.model;

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

@Entity
@Table(name = "Projekt")
public class Projekt {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_projekt;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "beschreibung")
	private String beschreibung;
	
	
	//viele Projekte können zum selben Kunden gehören
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Kunde.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_kunde")
	private Kunde kunde;
	
	@Column(name = "fruheste_stardat")
	private Date fruheste_stardat = new Date();
	
	@Column(name = "spatestes_enddat")
	private Date spatestes_enddat = new Date();
	
	//ein Projekt kann viele Aufgaben haben
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projekt")
    private List<Aufgabe> aufgaben;

	public Long getId_projekte() {
		return id_projekt;
	}

	public void setId_projekte(Long id_projekt) {
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

	public Kunde getkunde() {
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

	public List<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	public void setAufgaben(List<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	public Kunde getKunde() {
		return kunde;
	}


	
	
}
