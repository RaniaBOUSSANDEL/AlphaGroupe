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

import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Transaction;
import com.wha.springmvc.service.ClientService;
import com.wha.springmvc.service.ComptBancService;
import com.wha.springmvc.service.TransactionService;

@RestController
public class CompteBancRestController {

	@Autowired
	TransactionService transactionService;
	@Autowired
	ComptBancService comptBancService; // Service which will do all data retrieval/manipulation work
	@Autowired
	ClientService clientService;
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
	
	// -------------------Afficher la liste des transactions d'un Compte Bancaire-------------------------------	
	
	@RequestMapping(value = "/transactions/{numCompte}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transaction>> listAllTransactions(@PathVariable("numCompte") long numCompte) {
		List<Transaction> transactions = comptBancService.findTransactionsBynumCompte(numCompte);
		for (Transaction transaction : transactions) {
			System.out.println(transaction);
		}
		if (transactions.isEmpty()) {
			return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	//---------------------Afficher la liste des comptes------------------------
		
	@RequestMapping(value = "/compteBancaire/", method = RequestMethod.GET)
    public ResponseEntity<List<CompteBancaire>> listAllCompteBancaire() {
        List<CompteBancaire> compteBancaires = comptBancService.findAllCompteBanc();
        if(compteBancaires.isEmpty()){
            return new ResponseEntity<List<CompteBancaire>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<CompteBancaire>>(compteBancaires, HttpStatus.OK);
    }
	
	// -------------------Afficher la liste des Comptes d'un Client-------------------------------	
	
		@RequestMapping(value = "/compteBancaires/{idCl}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<CompteBancaire>> listAllCompteBancaires(@PathVariable("idCl") int idCl) {
			List<CompteBancaire> compteBancaires = comptBancService.findAllCompteBancByIdCl(idCl);
			for (CompteBancaire compteBancaire : compteBancaires) {
				System.out.println(compteBancaire);
			}
			if (compteBancaires.isEmpty()) {
				return new ResponseEntity<List<CompteBancaire>>(HttpStatus.NO_CONTENT);// You many decide to return
																				// HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<CompteBancaire>>(compteBancaires, HttpStatus.OK);
		}
}	
        
		

