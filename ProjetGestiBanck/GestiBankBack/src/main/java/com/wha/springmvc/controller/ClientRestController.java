package com.wha.springmvc.controller;

import java.util.Collection;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Visiteur;
import com.wha.springmvc.service.ClientService;

@RestController
public class ClientRestController {

	@Autowired
	ClientService clientService; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All
	// Clients-------------------------------------OK

	@RequestMapping(value = "/clients/", method = RequestMethod.GET)
	public ResponseEntity<Collection<Client>> listAllClients() {
		Collection<Client> clients = clientService.findAllClients();
		for (Client client : clients) {
			System.out.println(client);
		}
		if (clients.isEmpty()) {
			return new ResponseEntity<Collection<Client>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<Collection<Client>>(clients, HttpStatus.OK);
	}

	// -------------------Retrieve Single Client by id-------------------OK

	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> getClientById(@PathVariable("id") int id) {
		System.out.println("Fetching Client with id " + id);
		Client client = clientService.findById(id);
		if (client == null) {
			System.out.println("client with id " + id + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	// -------------------Retrieve Single Client by nom-------------------OK

	@RequestMapping(value = "/client/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> getClientByName(@PathVariable("name") String nom) {
		System.out.println("Fetching Client with name " + nom);
		Client client = clientService.findByName(nom);
		if (client == null) {
			System.out.println("client with name " + nom + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	
	// -------------------Retrieve liste compte-------------------OK

	
	@JsonIgnore	
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Collection<CompteBancaire>> getListCompte(@PathVariable("id") int id) {
			System.out.println("Fetching List comptes for Client with id " + id);
			Collection<CompteBancaire>  comptes = clientService.findListComptesForThisClient(id);
			if (comptes == null) {
				System.out.println("client with id " + id + " not found");
				return new ResponseEntity<Collection<CompteBancaire>>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Collection<CompteBancaire>>(comptes, HttpStatus.OK);
		}

	// -------------------Create a Client-------------------------------ok

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

	// ------------------- Update a Client --------------------------------------ok

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

	// ------------------- Update login and pw for this Client
	// --------------------------------------ok

	@RequestMapping(value = "/client/login/{login}/motDePasse/{mp}", method = RequestMethod.PUT)
	public ResponseEntity<Client> updateLoginMpClient(@PathVariable("login") String login,
			@PathVariable("mp") String mp, @RequestBody Client client) {
		System.out.println("Updating Client " + client.getId() + login + mp);

		Client currentClient = clientService.updateLoginMpClient(client, login, mp);

		if (currentClient == null) {
			System.out.println("Client with id " + client.getId() + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
	}

	// ------------------- affect Client for other
	// Conseiller--------------------------------------ok

	@RequestMapping(value = "/client/{id}/conseiller/{id_cons}", method = RequestMethod.PUT)
	public ResponseEntity<Client> updateConseillerForThisClient(@PathVariable("id") int id,
			@PathVariable("id_cons") int id_cons, @RequestBody Client client) {
		System.out.println("Updating conseiller for Client " + id);

		Client currentClient = clientService.updateConseillerForThisClient(client, id_cons);

		if (currentClient == null) {
			System.out.println("Client with id " + id + " not found");
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Client>(currentClient, HttpStatus.OK);
	}

	// ------------------- Delete a Client --------------------------------------ok

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
	
	// -------------------sent mail confirmation to this Client-------------------------------ok

//		@RequestMapping(value = "/client/{conseiller_id}", method = RequestMethod.POST)
//		public ResponseEntity<Void> sendMailConfirmation(@RequestBody Visiteur visiteur,
//				@PathVariable("conseiller_id") int conseiller_id, UriComponentsBuilder ucBuilder) {
//			System.out.println("Creating Client " + visiteur.getNom());
//
//			Client cl = clientService.createClient(visiteur, conseiller_id);
//
//			if (cl == null) {
//				System.out.println("A Client with name " + visiteur.getNom() + " already exist");
//				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//			} else {
//				HttpHeaders headers = new HttpHeaders();
//				headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(cl.getId()).toUri());
//				return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//			}
//
//		}
	
		// -------------------sent mail info to this Visiteur-------------------------------ok

//				@RequestMapping(value = "/client/{conseiller_id}", method = RequestMethod.POST)
//				public ResponseEntity<Void> sendMailConfirmation(@RequestBody Visiteur visiteur,
//						@PathVariable("conseiller_id") int conseiller_id, UriComponentsBuilder ucBuilder) {
//					System.out.println("Creating Client " + visiteur.getNom());
//
//					Client cl = clientService.createClient(visiteur, conseiller_id);
//
//					if (cl == null) {
//						System.out.println("A Client with name " + visiteur.getNom() + " already exist");
//						return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//					} else {
//						HttpHeaders headers = new HttpHeaders();
//						headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(cl.getId()).toUri());
//						return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//					}
//
//				}
}