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

import com.wha.springmvc.model.Visiteur;
import com.wha.springmvc.service.VisiteurService;

@RestController
public class VisiteurRestController {
	@Autowired
	VisiteurService visiteurService;
	
	/* -----------------------Créer un visiteur-------------------------------------------------*/
	@RequestMapping(value = "/visiteur/", method = RequestMethod.POST)
    public ResponseEntity<Void> createVisiteur(@RequestBody Visiteur visiteur, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Visiteur " + visiteur.toString());
//        System.out.println(demandeOuvertureCompte_id);
 
        if (visiteurService.isVisiteurExist(visiteur)!= null) {
            System.out.println("A Visiteur with name " + visiteur + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } 
        Visiteur vs=visiteurService.createVisiteur(visiteur);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/visiteur/").buildAndExpand(vs.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	/*--------------------------------- Suprimer un visiteur---------------------------------------*/
	@RequestMapping(value = "/visiteur/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Visiteur> deleteVisiteur(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Visiteur with id " + id);
 
        Visiteur visiteur = visiteurService.findById(id);
        if (visiteur == null) {
            System.out.println("Unable to delete. Visiteur with id " + id + " not found");
            return new ResponseEntity<Visiteur>(HttpStatus.NOT_FOUND);
        }
 
        visiteurService.deleteVisiteurById(id);
        return new ResponseEntity<Visiteur>(HttpStatus.NO_CONTENT);
    }
	
	/*-------------------------------------- MAJ d'un visiteur---------------------------------*/
	@RequestMapping(value = "/visiteur/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Visiteur> updateVisiteur(@PathVariable("id") int id, @RequestBody Visiteur visiteur) {
        System.out.println("Updating Visiteur " + id);
        System.out.println(visiteur); /// pour verifier 
         
        Visiteur currentVisiteur =  visiteurService.updateVisiteur(visiteur);
        System.out.println(currentVisiteur); // pour verifier
         
        if (currentVisiteur==null) {
            System.out.println("Visiteur with id " + id + " not found");
            return new ResponseEntity<Visiteur>(HttpStatus.NOT_FOUND);
        }
 
       
       
        return new ResponseEntity<Visiteur>(currentVisiteur, HttpStatus.OK);
    }
	
	/* ---------------------------------------------------Chercher un visiteur par son Id------------------------------------------------*/
	@RequestMapping(value = "/visiteur/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Visiteur> getVisiteur(@PathVariable("id") int id) {
        System.out.println("Fetching Visiteur with id " + id);
        Visiteur visiteur = visiteurService.findById(id);
        if (visiteur == null) {
            System.out.println("Visiteur with id " + id + " not found");
            return new ResponseEntity<Visiteur>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Visiteur>(visiteur, HttpStatus.OK);
    }
	
	/*--------------------------------------- Chercher un visiteur par son Nom----------------------------------------------------*/
	@RequestMapping(value = "/visiteur/{nom}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Visiteur> getVisiteur(@PathVariable("nom") String nom) {
        System.out.println("Fetching Visiteur with nom " + nom);
        Visiteur visiteur = visiteurService.findByNom(nom);
        if (visiteur == null) {
            System.out.println("Visiteur with id " + nom + " not found");
            return new ResponseEntity<Visiteur>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Visiteur>(visiteur, HttpStatus.OK);
    }
	
	/*-----------------------------------------afficher tt les visiteurs---------------------------------------------------------*/
	@RequestMapping(value = "/visiteur/", method = RequestMethod.GET)
    public ResponseEntity<List<Visiteur>> listAllVisiteurs() {
        List<Visiteur> visiteurs = visiteurService.findAllVisiteurs();
        if(visiteurs.isEmpty()){
            return new ResponseEntity<List<Visiteur>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Visiteur>>(visiteurs, HttpStatus.OK);
    }
}