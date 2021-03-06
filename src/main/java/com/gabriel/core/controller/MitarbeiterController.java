package com.gabriel.core.controller;

/*import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gabriel.core.exception.ResourceNotFoundException;
import com.gabriel.core.model.Aufgabe_mitarbeiter;
import com.gabriel.core.model.Mitarbeiter;
import com.gabriel.core.repository.MitarbeiterRep;

import javax.validation.Valid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * .
 * Despues cambiar lo de abajo para que ande la conexion con angular
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/mitarbeiter"})
public class MitarbeiterController {
	
	@Autowired
	MitarbeiterRep mitarbeiterRep;
	

	@GetMapping("/list")
    public List<Mitarbeiter> getAllMitarbeiter() {
        return mitarbeiterRep.findAll();
    }

    @PostMapping("/new")
    public Mitarbeiter createMitarbeiter(@Valid @RequestBody Mitarbeiter mitarbeiter) {
        return mitarbeiterRep.save(mitarbeiter);
    }

    @GetMapping("/list/{id}")
    public Mitarbeiter getMitarbeiterById(@PathVariable(value = "id") Long mitarbeiterId) {
        return mitarbeiterRep.findById(mitarbeiterId)
                .orElseThrow(() -> new ResourceNotFoundException("Mitarbeiter", "id", mitarbeiterId));
    }
    
    @GetMapping("/list/verfugbar/{ab}/{bis}/{id_skill}")
    public List<Mitarbeiter> mitarbeiterVerfugbar(@PathVariable(value = "ab") String s_ab,
    												@PathVariable(value = "bis") String s_bis,
    													@PathVariable(value = "id_skill") int id_skill) throws ParseException{
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date ab = sdf.parse(s_ab);
		Date bis = sdf.parse(s_bis);
    	
    	List<Mitarbeiter> result = mitarbeiterRep.findAllVerfugbar(ab, bis, id_skill);
    	return result;
    	
    }
    

    @PutMapping("/edit/{id}")
    public Mitarbeiter updateMitarbeiter(@PathVariable(value = "id") Long mitarbeiterId,
                                           @Valid @RequestBody Mitarbeiter mitarbeiterDetails) {

    	Mitarbeiter mitarbeiter = mitarbeiterRep.findById(mitarbeiterId)
                .orElseThrow(() -> new ResourceNotFoundException("Mitarbeiter", "id", mitarbeiterId));

        mitarbeiter.setVorname(mitarbeiterDetails.getVorname());
        mitarbeiter.setNachname(mitarbeiterDetails.getNachname());
        mitarbeiter.setImage(mitarbeiterDetails.getImage());
        mitarbeiter.setSkill(mitarbeiterDetails.getSkill());
        
        Mitarbeiter updatedmitarbeiter = mitarbeiterRep.save(mitarbeiter);
        return updatedmitarbeiter;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMitarbeiter(@PathVariable(value = "id") Long mitarbeiterId) {
        Mitarbeiter mitarbeiter = mitarbeiterRep.findById(mitarbeiterId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", mitarbeiterId));

        mitarbeiterRep.delete(mitarbeiter);

        return ResponseEntity.ok().build();
    }
    
    
    

}
