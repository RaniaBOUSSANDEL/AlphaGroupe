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
import com.wha.springmvc.model.Visiteur;
import com.wha.springmvc.service.ClientService;

@RestController
public class ClientRestController {

	@Autowired
	ClientService clientService; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Clients-------------------------------------

	@RequestMapping(value = "/clients/", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> listAllClients() {
		List<Client> clients = clientService.findAllClients();
		for (Client client : clients) {
			System.out.println(client);
		}
		if (clients.isEmpty()) {
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
	}

	// -------------------Retrieve Single Client-------------------

	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> getClient(@PathVariable("id") int id) {
		System.out.println("Fetching Client with id " + id);
		Client client = clientService.findById(id);
		if (client == null) {
			System.out.println("client with id " + id + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	// -------------------Create a Client-------------------------------

	@RequestMapping(value = "/client/{conseiller_id}", method = RequestMethod.POST)
	public ResponseEntity<Void> createClient(@RequestBody Visiteur visiteur,
			@PathVariable("conseiller_id") int conseiller_id, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Client " + visiteur.getNom());

		Client cl = clientService.createClient(visiteur, conseiller_id);

		if (cl == null) {
			System.out.println("A Client with name " + visiteur.getNom() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(cl.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

	}

	// ------------------- Update a Client --------------------------------------

	@RequestMapping(value = "/client/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> updateClient(@PathVariable("id") int id, @RequestBody Client client) {
		System.out.println("Updating Client " + id);

		Client currentClient = clientService.updateClient(client);

		if (currentClient == null) {
			System.out.println("Client with id " + id + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
	}

	// ------------------- affect Client for other
	// Conseiller--------------------------------------

	@RequestMapping(value = "/client/{id}/conseiller/{id_cons}", method = RequestMethod.PUT)
	public ResponseEntity<Client> affectClientForNewConseiller(@PathVariable("id") int id,
			@PathVariable("id_cons") int id_cons, @RequestBody Client client) {
		System.out.println("Updating conseiller for Client " + id);

		Client currentClient = clientService.updateConseillerForThisClient(client, id_cons);

		if (currentClient == null) {
			System.out.println("Client with id " + id + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
	}

	// ------------------- Delete a Client --------------------------------------

	@RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> deleteClient(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Client with id " + id);

		Client client = clientService.findById(id);
		if (client == null) {
			System.out.println("Unable to delete. Client with id " + id + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		clientService.deleteClientById(id);
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}

}