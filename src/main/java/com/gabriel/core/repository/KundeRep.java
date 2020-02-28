package com.gabriel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.core.model.Kunde;

@Repository
public interface KundeRep extends JpaRepository<Kunde, Long> {

}
