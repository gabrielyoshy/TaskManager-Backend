package com.gabriel.core.service;

import java.util.List;

import com.gabriel.core.model.Skill;

public interface SkillService {
	
	List<Skill>list();
	Skill findOne(long id);
	Skill save(Skill s);
	Skill edit(Skill s);
	Skill delete(long id);

}
