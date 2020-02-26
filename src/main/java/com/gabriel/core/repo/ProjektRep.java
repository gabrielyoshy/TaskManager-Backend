package com.gabriel.core.repo;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.core.model.Projekt;

@Repository
public interface ProjektRep extends PagingAndSortingRepository<Projekt, Long> {
}
