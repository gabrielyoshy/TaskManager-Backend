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
import javax.persistence.Lob;
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
@Table(name = "Aufgabe_mitarbeiter")

public class Aufgabe_mitarbeiter implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_aufgab_mitarb;
		
	//Es gibt nur eine Aufgabe pro Datensatz 
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_aufgabe")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id_aufgabe")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("aufgabe")
    private Aufgabe aufgabe;
	
	//Es gibt nur einen Mitarbeiter pro Datensatz 
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "mitarbeiter", nullable = false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id_mitarbeiter")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("mitarbeiter")
    private Mitarbeiter mitarbeiter;
	
	@Column(name = "ab")
	private Date ab;
	
	@Column(name = "bis")
	private Date bis;
 
	public Long getId_aufgab_mitarb() {
		return id_aufgab_mitarb;
	}

	public void setId_aufgab_mitarb(Long id_aufgab_mitarb) {
		this.id_aufgab_mitarb = id_aufgab_mitarb;
	}

	public Aufgabe getAufgabe() {
		return aufgabe;
	}

	public void setAufgabe(Aufgabe aufgabe) {
		this.aufgabe = aufgabe;
	}

	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public Date getAb() {
		return ab;
	}

	public void setAb(Date ab) {
		this.ab = ab;
	}

	public Date getBis() {
		return bis;
	}

	public void setBis(Date bis) {
		this.bis = bis;
	}
	
	
}
