package com.gabriel.core.controller;

/*import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gabriel.core.exception.ResourceNotFoundException;
import com.gabriel.core.model.Aufgabe;
import com.gabriel.core.repository.AufgabeRep;

import javax.validation.Valid;
import java.util.List;

/**
 * .
 * Despues cambiar lo de abajo para que ande la conexion con angular
 */

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/aufgabe"})
public class AufgabeController {
	
	@Autowired
	AufgabeRep aufgabeRep;
	

	@GetMapping("/list")
    public List<Aufgabe> getAllAufgabe() {
        return aufgabeRep.findAll();
    }

    @PostMapping("/new")
    public Aufgabe createAufgabe(@Valid @RequestBody Aufgabe aufgabe) {
        return aufgabeRep.save(aufgabe);
    }

    @GetMapping("/list/{id}")
    public Aufgabe getAufgabeById(@PathVariable(value = "id") Long aufgabeId) {
        return aufgabeRep.findById(aufgabeId)
                .orElseThrow(() -> new ResourceNotFoundException("Aufgabe", "id", aufgabeId));
    }

    @PutMapping( value="/edit/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Aufgabe updateAufgabe(@PathVariable(value = "id") Long aufgabeId,
                                           @Valid @RequestBody Aufgabe aufgabeDetails) {

    	Aufgabe aufgabe = aufgabeRep.findById(aufgabeId)
                .orElseThrow(() -> new ResourceNotFoundException("Aufgabe", "id", aufgabeId));

        aufgabe.setName(aufgabeDetails.getName());
        aufgabe.setBeschreibung(aufgabeDetails.getBeschreibung());
        aufgabe.setGeschatzter_aufwand(aufgabeDetails.getGeschatzter_aufwand());
        aufgabe.setSkill(aufgabeDetails.getSkill());
        aufgabe.setProjekt(aufgabeDetails.getProjekt());

        Aufgabe updatedAufgabe = aufgabeRep.save(aufgabe);
        return updatedAufgabe;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAufgabe(@PathVariable(value = "id") Long aufgabeId) {
        Aufgabe aufgabe = aufgabeRep.findById(aufgabeId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", aufgabeId));

        aufgabeRep.delete(aufgabe);

        return ResponseEntity.ok().build();
    }

}
