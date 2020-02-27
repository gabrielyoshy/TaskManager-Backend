package com.gabriel.core.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.core.model.Skill;
import com.gabriel.core.repo.SkillRep;
import com.gabriel.core.service.SkillService;

@Service
public class SkillImp implements SkillService {

	@Autowired
	private SkillRep repositorio;
	
	@Override
	public List<Skill> list() {
		return repositorio.findAll();
	}

	/*@Override
	public Skill listId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill add(Skill s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill edit(Skill s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
