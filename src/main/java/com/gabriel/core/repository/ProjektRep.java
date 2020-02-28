package com.gabriel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.core.model.Projekt;

@Repository
public interface ProjektRep extends JpaRepository<Projekt, Long> {

}
