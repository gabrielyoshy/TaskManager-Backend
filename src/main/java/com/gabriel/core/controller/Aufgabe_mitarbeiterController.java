package com.gabriel.core.controller;

/*import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gabriel.core.exception.ResourceNotFoundException;
import com.gabriel.core.model.Aufgabe_mitarbeiter;
import com.gabriel.core.repository.Aufgabe_mitarbeiterRep;

import javax.validation.Valid;
import java.util.List;

/**
 * .
 * Despues cambiar lo de abajo para que ande la conexion con angular
 */

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/aufgabe_mitarbeiter"})
public class Aufgabe_mitarbeiterController {
	
	@Autowired
	Aufgabe_mitarbeiterRep aufgabe_mitarbeiterRep;
	

	@GetMapping("/list")
    public List<Aufgabe_mitarbeiter> getAllAufgabe_mitarbeiter() {
        return aufgabe_mitarbeiterRep.findAll();
    }

    @PostMapping("/new")
    public Aufgabe_mitarbeiter createAufgabe_mitarbeiter(@Valid @RequestBody Aufgabe_mitarbeiter aufgabe_mitarbeiter) {
        return aufgabe_mitarbeiterRep.save(aufgabe_mitarbeiter);
    }

    @GetMapping("/list/{id}")
    public Aufgabe_mitarbeiter getAufgabe_mitarbeiterById(@PathVariable(value = "id") Long aufgabe_mitarbeiterId) {
        return aufgabe_mitarbeiterRep.findById(aufgabe_mitarbeiterId)
                .orElseThrow(() -> new ResourceNotFoundException("Aufgabe_mitarbeiter", "id", aufgabe_mitarbeiterId));
    }

    @PutMapping("/edit/{id}")
    public Aufgabe_mitarbeiter updateAufgabe_mitarbeiter(@PathVariable(value = "id") Long aufgabe_mitarbeiterId,
                                           @Valid @RequestBody Aufgabe_mitarbeiter aufgabe_mitarbeiterDetails) {

    	Aufgabe_mitarbeiter aufgabe_mitarbeiter = aufgabe_mitarbeiterRep.findById(aufgabe_mitarbeiterId)
                .orElseThrow(() -> new ResourceNotFoundException("aufgabe_mitarbeiter", "id", aufgabe_mitarbeiterId));

        aufgabe_mitarbeiter.setAufgabe(aufgabe_mitarbeiterDetails.getAufgabe());
        aufgabe_mitarbeiter.setMitarbeiter(aufgabe_mitarbeiterDetails.getMitarbeiter());
        aufgabe_mitarbeiter.setAb(aufgabe_mitarbeiterDetails.getAb());
        aufgabe_mitarbeiter.setBis(aufgabe_mitarbeiterDetails.getBis());
        
        Aufgabe_mitarbeiter updatedAufgabe_mitarbeiter = aufgabe_mitarbeiterRep.save(aufgabe_mitarbeiter);
        return updatedAufgabe_mitarbeiter;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAufgabe_mitarbeiter(@PathVariable(value = "id") Long aufgabe_mitarbeiterId) {
        Aufgabe_mitarbeiter aufgabe_mitarbeiter = aufgabe_mitarbeiterRep.findById(aufgabe_mitarbeiterId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", aufgabe_mitarbeiterId));

        aufgabe_mitarbeiterRep.delete(aufgabe_mitarbeiter);

        return ResponseEntity.ok().build();
    }

}
