package com.gabriel.core.repo;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.core.model.Aufgabe;

@Repository
public interface AufgabeRep extends PagingAndSortingRepository<Aufgabe, Long> {
	
	public abstract Aufgabe findByName(String name);
	
	public abstract List<Aufgabe> findAll();
}

