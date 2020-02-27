package com.gabriel.core.repo;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.gabriel.core.model.Skill;


public interface SkillRep extends Repository<Skill, Long> {
	List<Skill>findAll();
	/*Skill findOne(long id);
	Skill save(Skill s);
	void delete(Skill s);*/
}
