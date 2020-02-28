package com.gabriel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.core.model.Aufgabe_mitarbeiter;

@Repository
public interface Aufgabe_mitarbeiterRep extends JpaRepository<Aufgabe_mitarbeiter, Long> {

}
