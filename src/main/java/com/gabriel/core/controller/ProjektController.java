package com.gabriel.core.controller;

/*import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gabriel.core.exception.ResourceNotFoundException;
import com.gabriel.core.model.Projekt;
import com.gabriel.core.repository.ProjektRep;

import javax.validation.Valid;
import java.util.List;

/**
 * .
 * Despues cambiar lo de abajo para que ande la conexion con angular
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/projekt"})
public class ProjektController {
	
	@Autowired
	ProjektRep projektRep;
	

	@GetMapping("/list")
    public List<Projekt> getAllProjekt() {
        return projektRep.findAll();
    }

    @PostMapping("/new")
    public Projekt createProjekt(@Valid @RequestBody Projekt projekt) {
        return projektRep.save(projekt);
    }

    @GetMapping("/list/{id}")
    public Projekt getProjektById(@PathVariable(value = "id") Long projektId) {
        return projektRep.findById(projektId)
                .orElseThrow(() -> new ResourceNotFoundException("Projekt", "id", projektId));
    }

    @PutMapping("/edit/{id}")
    public Projekt updateProjekt(@PathVariable(value = "id") Long projektId,
                                           @Valid @RequestBody Projekt projektDetails) {

    	Projekt projekt = projektRep.findById(projektId)
                .orElseThrow(() -> new ResourceNotFoundException("Projekt", "id", projektId));

        projekt.setName(projektDetails.getName());
        projekt.setBeschreibung(projektDetails.getBeschreibung());
        projekt.setKunde(projektDetails.getKunde());
        projekt.setFruheste_stardat(projektDetails.getFruheste_stardat());
        projekt.setSpatestes_enddat(projektDetails.getSpatestes_enddat());

        Projekt updatedProjekt = projektRep.save(projekt);
        return updatedProjekt;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProjekt(@PathVariable(value = "id") Long projektId) {
        Projekt projekt = projektRep.findById(projektId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", projektId));

        projektRep.delete(projekt);

        return ResponseEntity.ok().build();
    }

}
