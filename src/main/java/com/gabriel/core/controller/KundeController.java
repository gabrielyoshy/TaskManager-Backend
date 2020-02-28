package com.gabriel.core.controller;

/*import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gabriel.core.exception.ResourceNotFoundException;
import com.gabriel.core.model.Kunde;
import com.gabriel.core.repository.KundeRep;

import javax.validation.Valid;
import java.util.List;

/**
 * .
 * Despues cambiar lo de abajo para que ande la conexion con angular
 */

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/kunde"})
public class KundeController {
	
	@Autowired
	KundeRep kundeRep;
	

	@GetMapping("/list")
    public List<Kunde> getAllKunde() {
        return kundeRep.findAll();
    }

    @PostMapping("/new")
    public Kunde createKunde(@Valid @RequestBody Kunde kunde) {
        return kundeRep.save(kunde);
    }

    @GetMapping("/list/{id}")
    public Kunde getKundeById(@PathVariable(value = "id") Long kundeId) {
        return kundeRep.findById(kundeId)
                .orElseThrow(() -> new ResourceNotFoundException("Kunde", "id", kundeId));
    }

    @PutMapping("/edit/{id}")
    public Kunde updateKunde(@PathVariable(value = "id") Long kundeId,
                                           @Valid @RequestBody Kunde kundeDetails) {

    	Kunde kunde = kundeRep.findById(kundeId)
                .orElseThrow(() -> new ResourceNotFoundException("Kunde", "id", kundeId));

        kunde.setVorname(kundeDetails.getVorname());
        kunde.setNachname(kundeDetails.getNachname());
        kunde.setProjekte(kundeDetails.getProjekte());

        Kunde updatedKunde = kundeRep.save(kunde);
        return updatedKunde;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteKunde(@PathVariable(value = "id") Long kundeId) {
        Kunde kunde = kundeRep.findById(kundeId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", kundeId));

        kundeRep.delete(kunde);

        return ResponseEntity.ok().build();
    }

}
