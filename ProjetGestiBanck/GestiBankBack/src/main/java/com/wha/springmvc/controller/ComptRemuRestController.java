package com.wha.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wha.springmvc.model.CompteRemunerateur;
import com.wha.springmvc.service.CompteRemuService;

@RestController
public class ComptRemuRestController {
	@Autowired
	CompteRemuService comptRemuService;
	
	// -------------------Create a Compte Decouvert-------------------------------

			@RequestMapping(value = "/compteRemu/{client_id}", method = RequestMethod.POST)
			public ResponseEntity<Void> createCompteRemunere(@RequestBody CompteRemunerateur compteRemunerateur,
					UriComponentsBuilder ucBuilder, @PathVariable("client_id") int client_id) {
				System.out.println("Creating compte " + compteRemunerateur.getNumCompte());

				if (comptRemuService.findByNumeroCompte(compteRemunerateur.getNumCompte())!=null) {
		            System.out.println("A compteBanc with Numero " + compteRemunerateur.getNumCompte() + " already exist");
		            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		        }
//				CompteCourant c = new CompteCourant();
//				CompteBancaire cc = (CompteBancaire)c;

				
				comptRemuService.save(compteRemunerateur, client_id);
		 
		        HttpHeaders headers = new HttpHeaders();
		        headers.setLocation(ucBuilder.path("/compteRemu/{num}").buildAndExpand(compteRemunerateur.getNumCompte()).toUri());
		        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			}
}
