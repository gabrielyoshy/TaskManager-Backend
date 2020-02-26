package com.gabriel.core.repo;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.core.model.Aufgabe;

@Repository
public interface AufgabeRep extends PagingAndSortingRepository<Aufgabe, Long> {
}

