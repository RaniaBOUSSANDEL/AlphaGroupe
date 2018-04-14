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
import com.wha.springmvc.model.DemandeOuvertureCompte;
import com.wha.springmvc.model.Visiteur;
import com.wha.springmvc.service.DemandeCompteService;

@RestController
public class DemandeCompteRestController {
	
	@Autowired
	DemandeCompteService demandeCompteService;
	
	// -------------------Create a Demande-------------------------------
	@RequestMapping(value = "/demandeCompte/", method = RequestMethod.POST)
	public ResponseEntity<DemandeOuvertureCompte>createDemandeCompte( UriComponentsBuilder ucBuilder){
		 System.out.println("Creating Demande ");
		 DemandeOuvertureCompte dCompte = demandeCompteService.createDemandeCompte();
		 if (dCompte == null) {
				System.out.println("A Demande already exist");
				return new ResponseEntity<DemandeOuvertureCompte>(HttpStatus.CONFLICT);
			} else {
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(ucBuilder.path("/demandeCompte/").buildAndExpand(dCompte.getIdDemande()
						).toUri());
				return new ResponseEntity<DemandeOuvertureCompte>(headers, HttpStatus.CREATED);
			}
	 }
	// ------------------- affecter une demande--------------------------------------
	@RequestMapping(value = "/demandeCompte/{demande_id}/{conseiller_id}", method = RequestMethod.PUT)
	public ResponseEntity<DemandeOuvertureCompte>affecterDemande(@PathVariable("demande_id") int demande_id,
			@PathVariable("conseiller_id") int conseiller_id, UriComponentsBuilder ucBuilder){
		System.out.println("Affectation Demande ");
		DemandeOuvertureCompte dcCompte=demandeCompteService.affecterDemande(demande_id, conseiller_id);
		
		return new ResponseEntity<DemandeOuvertureCompte>(dcCompte, HttpStatus.OK);
	}
	
	/*-----------------------------------------afficher tt les demandes de Compte---------------------------------------------------------*/
	@RequestMapping(value = "/demandeCompte/", method = RequestMethod.GET)
    public ResponseEntity<List<DemandeOuvertureCompte>> listAllDemandeCompte() {
        List<DemandeOuvertureCompte> demandes = demandeCompteService.findAllDemandes();
        if(demandes.isEmpty()){
            return new ResponseEntity<List<DemandeOuvertureCompte>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<DemandeOuvertureCompte>>(demandes, HttpStatus.OK);
    }
	/*-----------------------------------------afficher tt les demandes de Compte---------------------------------------------------------*/
	@RequestMapping(value = "/demandeCompte/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DemandeOuvertureCompte> getdemandeCompte(@PathVariable("id") int id) {
		System.out.println("Fetching Client with id " + id);
		DemandeOuvertureCompte demandeCompte = demandeCompteService.findById(id);
		if (demandeCompte == null) {
			System.out.println("demandeCompte with id " + id + " not found");
			return new ResponseEntity<DemandeOuvertureCompte>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<DemandeOuvertureCompte>(demandeCompte, HttpStatus.OK);
	}

}