package com.gabriel.core.controller;

/*import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gabriel.core.exception.ResourceNotFoundException;
import com.gabriel.core.model.Skill;
import com.gabriel.core.repository.SkillRep;

import javax.validation.Valid;
import java.util.List;

/**
 * .
 * Despues cambiar lo de abajo para que ande la conexion con angular
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/skill"})
public class SkillController {
	
	@Autowired
	SkillRep skillRep;
	

	@GetMapping("/list")
    public List<Skill> getAllSkill() {
        return skillRep.findAll();
    }

    @PostMapping("/new")
    public Skill createSkill(@Valid @RequestBody Skill skill) {
        return skillRep.save(skill);
    }

    @GetMapping("/list/{id}")
    public Skill getSkillById(@PathVariable(value = "id") Long skillId) {
        return skillRep.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", skillId));
    }

    @PutMapping("/edit/{id}")
    public Skill updateSkill(@PathVariable(value = "id") Long skillId,
                                           @Valid @RequestBody Skill skillDetails) {

    	Skill skill = skillRep.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", skillId));

        skill.setName(skillDetails.getName());
        skill.setBeschreibung(skillDetails.getBeschreibung());

        Skill updatedSkill = skillRep.save(skill);
        return updatedSkill;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable(value = "id") Long skillId) {
        Skill skill = skillRep.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", skillId));

        skillRep.delete(skill);

        return ResponseEntity.ok().build();
    }

}
