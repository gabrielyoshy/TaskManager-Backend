package com.gabriel.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.core.model.Skill;

@Repository
public interface SkillRep extends JpaRepository<Skill, Long> {

}
