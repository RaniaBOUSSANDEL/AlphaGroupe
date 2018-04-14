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
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.service.ComptCouService;

@RestController
public class ComptCouRestController {
	@Autowired
	ComptCouService comptCouService;
	
	// -------------------Create a Compte courant-------------------------------

			@RequestMapping(value = "/compteCourant/{client_id}", method = RequestMethod.POST)
			public ResponseEntity<Void> createCompteCourant(@RequestBody CompteCourant compteCourant,
					UriComponentsBuilder ucBuilder, @PathVariable("client_id") int client_id) {
				System.out.println("Creating compte " + compteCourant.getNumCompte());

				if (comptCouService.findByNumeroCompte(compteCourant.getNumCompte())!=null) {
		            System.out.println("A compteBanc with Numero " + compteCourant.getNumCompte() + " already exist");
		            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		        }
//				CompteCourant c = new CompteCourant();
//				CompteBancaire cc = (CompteBancaire)c;

				
				comptCouService.save(compteCourant, client_id);
		 
		        HttpHeaders headers = new HttpHeaders();
		        headers.setLocation(ucBuilder.path("/compteCourant/{num}").buildAndExpand(compteCourant.getNumCompte()).toUri());
		        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			}
}
