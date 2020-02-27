package com.gabriel.core.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.core.model.Skill;
import com.gabriel.core.service.SkillService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/skills"})
public class Controller {
	
	@Autowired
	SkillService service;
	

	@GetMapping
	public List<Skill>list(){
		return service.list();
	}
	
	@PostMapping
	public Skill add(@RequestBody Skill s){
		return service.save(s);
	}
	/*
	@PostMapping
	public String add(@RequestBody String s){
		return s;
	}*/

}
