package com.gabriel.core;

import java.awt.datatransfer.SystemFlavorMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.gabriel.core.controller.*;
import com.gabriel.core.repository.MitarbeiterRep;

@SpringBootApplication
@EnableJpaAuditing
public class TaskManagerBackendApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TaskManagerBackendApplication.class, args);
	
	
	
	
	}

}
