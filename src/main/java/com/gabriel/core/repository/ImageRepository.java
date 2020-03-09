package com.gabriel.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.core.model.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
}