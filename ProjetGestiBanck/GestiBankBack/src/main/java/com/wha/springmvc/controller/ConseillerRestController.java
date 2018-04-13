package com.wha.springmvc.controller;

import java.util.Collection;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.service.ConseillerService;


@RestController
public class ConseillerRestController {

	@Autowired
	ConseillerService conseillerService; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Conseillers-------------------------------------

	@RequestMapping(value = "/conseillers/", method = RequestMethod.GET)
	public ResponseEntity<Collection<Conseiller>> listAllConseillers() {
		Collection<Conseiller> conseillers = conseillerService.findAllConseillers();
		for (Conseiller conseiller : conseillers) {
			System.out.println(conseiller);
		}
		if (conseillers.isEmpty()) {
			return new ResponseEntity<Collection<Conseiller>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Collection<Conseiller>>(conseillers, HttpStatus.OK);
	}

	// -------------------Retrieve Single conseiller by id-------------------

	@RequestMapping(value = "/conseillers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conseiller> getConseillerById(@PathVariable("id") int id) {
		System.out.println("Fetching Conseiller with id " + id);
		Conseiller conseiller = conseillerService.findById(id);
		if (conseiller == null) {
			System.out.println("conseiller with id " + id + " not found");
			return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Conseiller>(conseiller, HttpStatus.OK);
	}
	
	// -------------------Retrieve Single conseiller by nom-------------------

		@RequestMapping(value = "/conseiller/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Conseiller> getConseillerByName(@PathVariable("name") String nom) {
			System.out.println("Fetching Conseiller with name " + nom);
			Conseiller conseiller = conseillerService.findByName(nom);
			if (conseiller == null) {
				System.out.println("Conseiller with name " + nom + " not found");
				return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Conseiller>(conseiller, HttpStatus.OK);
		}
		
		
		// -------------------Retrieve liste clients-------------------OK

		
			
		@RequestMapping(value = "/conseiller/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<Collection<Client>> getListClient(@PathVariable("id") int id) {
				System.out.println("Fetching List clients for Conseiller with id " + id);
				Collection<Client>  clients = conseillerService.findListClientsForThisConseiller(id);
				if (clients == null) {
					System.out.println("list client for conseiller with id " + id + " not found");
					return new ResponseEntity<Collection<Client>>(HttpStatus.NOT_FOUND);
				}
				return new ResponseEntity<Collection<Client>>(clients, HttpStatus.OK);
			}


	// -------------------Create a conseiller-------------------------------

	@RequestMapping(value = "/conseiller/admin/{admin_id}", method = RequestMethod.POST)
	public ResponseEntity<Void> createConseiller(@RequestBody Conseiller conseiller,
			@PathVariable("admin_id") int admin_id, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating conseiller " + conseiller.getNom());

		Conseiller co = conseillerService.createConseiller(conseiller, admin_id);

		if (co == null) {
			System.out.println("A conseiller with name " + conseiller.getNom() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/conseiller/{id}").buildAndExpand(co.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

	}

	// ------------------- Update a conseiller --------------------------------------

	@RequestMapping(value = "/conseiller/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Conseiller> updateConseiller(@PathVariable("id") int id, @RequestBody Conseiller conseiller) {
		System.out.println("Updating Conseiller " + id);

		Conseiller currentConseiller = conseillerService.updateConseiller(conseiller);

		if (currentConseiller == null) {
			System.out.println("Conseiller with id " + id + " not found");
			return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Conseiller>(currentConseiller, HttpStatus.OK);
	}
	
	
	// ------------------- Update login and pw for this Conseiller--------------------------ok

		@RequestMapping(value = "/conseiller/login/{login}/motDePasse/{mp}", method = RequestMethod.PUT)
		public ResponseEntity<Conseiller> updateLoginMpConseiller(@PathVariable("login") String login,
				@PathVariable("mp") String mp, @RequestBody Conseiller conseiller) {
			System.out.println("Updating Conseiller " + conseiller.getId() + login + mp);

			Conseiller currentConseiller = conseillerService.updateLoginMpConseiller(conseiller, login, mp);

			if (currentConseiller == null) {
				System.out.println("Conseiller with id " + conseiller.getId() + " not found");
				return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<Conseiller>(currentConseiller, HttpStatus.OK);
		}

	

	// ------------------- affect Client for other
	// Conseiller--------------------------------------

//	@RequestMapping(value = "/client/{id}/conseiller/{id_cons}", method = RequestMethod.PUT)
//	public ResponseEntity<Client> affectClientForNewConseiller(@PathVariable("id") int id,
//			@PathVariable("id_cons") int id_cons, @RequestBody Client client) {
//		System.out.println("Updating conseiller for Client " + id);
//
//		Client currentClient = clientService.updateConseillerForThisClient(client, id_cons);
//
//		if (currentClient == null) {
//			System.out.println("Client with id " + id + " not found");
//			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
//	}

	// ------------------- Delete a Client --------------------------------------

	@RequestMapping(value = "/conseiller/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Conseiller> deleteConseiller(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Conseiller with id " + id);

		Conseiller conseiller = conseillerService.findById(id);
		if (conseiller == null) {
			System.out.println("Unable to delete. Conseiller with id " + id + " not found");
			return new ResponseEntity<Conseiller>(HttpStatus.NOT_FOUND);
		}

		conseillerService.deleteConseillerById(id);
		return new ResponseEntity<Conseiller>(HttpStatus.NO_CONTENT);
	}

}