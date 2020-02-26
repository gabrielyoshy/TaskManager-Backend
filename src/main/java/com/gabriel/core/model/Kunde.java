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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Kunde")
public class Kunde {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_kunde;
	
	@Column(name = "vorname")
	private String vorname;
	
	@Column(name = "nachname")
	private String nachname;
	
	//nur ein Kunde pro Projekt
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "kunde")
    private List<Projekt> projekteList = new ArrayList<>();
	
	public Long getId_kunde() {
		return id_kunde;
	}

	public void setId_kunde(Long id_kunde) {
		this.id_kunde = id_kunde;
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

	public List<Projekt> getProjekte() {
		return projekteList;
	}

	public void setProjekte(List<Projekt> projekteList) {
		this.projekteList = projekteList;
	}

}
