package com.gabriel.core.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gabriel.core.model.Mitarbeiter;

@Repository
public interface MitarbeiterRep extends JpaRepository<Mitarbeiter, Long> {

	@Query(value = "SELECT mit.* FROM mitarbeiter mit\r\n" + 
			"LEFT JOIN (SELECT m.id_mitarbeiter as id FROM mitarbeiter m\r\n" + 
			"                INNER JOIN aufgabe_mitarbeiter am\r\n" + 
			"                    ON m.id_mitarbeiter = am.mitarbeiter\r\n" + 
			"                WHERE am.ab >= ?1 AND am.ab <= ?2 OR am.bis >= ?1 AND am.bis <= ?2) AS beschaftigt\r\n" + 
			"	ON mit.id_mitarbeiter = beschaftigt.id\r\n" + 
			"INNER JOIN mitarbeiter_skill sk\r\n" + 
			"	ON sk.mitarbeiters_id_mitarbeiter = mit.id_mitarbeiter \r\n" + 
			"WHERE beschaftigt.id is NULL\r\n" + 
			"	AND sk.skill_id_skill = ?3 ", nativeQuery = true)
    List<Mitarbeiter> findAllVerfugbar(Date ab, Date bis, int id_skill);
	
	
	
	
	
}
