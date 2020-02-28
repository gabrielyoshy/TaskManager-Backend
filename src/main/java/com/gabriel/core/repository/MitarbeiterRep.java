package com.gabriel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.core.model.Mitarbeiter;

@Repository
public interface MitarbeiterRep extends JpaRepository<Mitarbeiter, Long> {

}
