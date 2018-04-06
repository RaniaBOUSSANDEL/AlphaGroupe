package com.wha.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Visiteur;
import com.wha.springmvc.service.ClientService;
import com.wha.springmvc.service.ComptBancService;

@RestController
public class CompteBancRestController {

	@Autowired
	ComptBancService comptBancService; // Service which will do all data retrieval/manipulation work
	
	// -------------------Create a Compte Bancaire-------------------------------

	@RequestMapping(value = "/compteBancaire/{client_id}", method = RequestMethod.POST)
	public ResponseEntity<Void> createCompteBanc(@RequestBody CompteBancaire compteBancaire,
			UriComponentsBuilder ucBuilder, @PathVariable("client_id") int client_id) {
		System.out.println("Creating compte " + compteBancaire.getNumCompte());

		if (comptBancService.findByNumeroCompte(compteBancaire.getNumCompte())!=null) {
            System.out.println("A compteBanc with Numero " + compteBancaire.getNumCompte() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
		comptBancService.save(compteBancaire, client_id);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/compteBancaire/{num}").buildAndExpand(compteBancaire.getNumCompte()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	// -------------------Trouver Compte Bancaire-------------------------------	

	@RequestMapping(value = "/compteBancaire/{numCompt}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompteBancaire> getCompteBanc(@PathVariable("numCompt") long numCompt) {
		System.out.println("Fetching Compte Bancaire with numCompte " + numCompt);
		CompteBancaire compteBancaire = comptBancService.findByNumeroCompte(numCompt);
		if (compteBancaire == null) {
			System.out.println("compte with numCompt " + numCompt + " not found");
			return new ResponseEntity<CompteBancaire>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CompteBancaire>(compteBancaire, HttpStatus.OK);
	}

}