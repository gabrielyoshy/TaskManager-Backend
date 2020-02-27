package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.core.model.Skill;
import com.gabriel.core.service.SkillService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/skill"})
public class Controller {
	
	@Autowired
	SkillService skill;
	
	@GetMapping
	public List<Skill>list(){
		return skill.list();
	}
	

}
