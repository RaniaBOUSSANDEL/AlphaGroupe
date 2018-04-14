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

import com.wha.springmvc.model.CompteAvecDecouv;
import com.wha.springmvc.service.ComptDecouService;

@RestController
public class ComptDecouvRestController {
	@Autowired
	ComptDecouService comptDecouService;
	
	// -------------------Create a Compte Decouvert-------------------------------

			@RequestMapping(value = "/compteAvecDecouvert/{client_id}/{revenu}", method = RequestMethod.POST)
			public ResponseEntity<Void> createCompteDecouvert(@RequestBody CompteAvecDecouv compteAvecDecouv, 
					UriComponentsBuilder ucBuilder, @PathVariable("client_id") int client_id,  @PathVariable ("revenu") float revenu) {
				System.out.println("Creating compte " + compteAvecDecouv.getNumCompte());

				if (comptDecouService.findByNumeroCompte(compteAvecDecouv.getNumCompte())!=null) {
		            System.out.println("A compteBanc with Numero " + compteAvecDecouv.getNumCompte() + " already exist");
		            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		        }
//				CompteCourant c = new CompteCourant();
//				CompteBancaire cc = (CompteBancaire)c;

				
				comptDecouService.save(compteAvecDecouv, client_id, revenu);
		 
		        HttpHeaders headers = new HttpHeaders();
		        headers.setLocation(ucBuilder.path("/compteAvecDecouvert/{client_id}/{revenu}").buildAndExpand(compteAvecDecouv.getNumCompte(), revenu).toUri());
		        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			}
}
