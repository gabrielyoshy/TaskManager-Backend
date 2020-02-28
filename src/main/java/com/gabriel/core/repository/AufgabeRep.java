package com.gabriel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.core.model.Aufgabe;

@Repository
public interface AufgabeRep extends JpaRepository<Aufgabe, Long> {

}
