package com.gabriel.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gabriel.core.model.Aufgabe_mitarbeiter;
import com.gabriel.core.model.Mitarbeiter;
import com.gabriel.core.repository.Aufgabe_mitarbeiterRep;
import com.gabriel.core.repository.MitarbeiterRep;
import com.gabriel.core.controller.MitarbeiterController;

@SpringBootTest
class TaskManagerBackendApplicationTests {
	
	
	@Autowired
	MitarbeiterRep mitarbeiterRep;
	

	@Test
	void test1() throws ParseException {
		
		// Usaremos el formato de fecha que necesitemos
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date ab = sdf.parse("2020-03-04");
		Date bis = sdf.parse("2020-04-31");
		int skill = 5;
		
		List<Mitarbeiter> list1 = mitarbeiterRep.findAllVerfugbar(ab, bis, skill); 
		
		for(Mitarbeiter x : list1) {
			System.out.println(x.getVorname());
		}
	}

}
