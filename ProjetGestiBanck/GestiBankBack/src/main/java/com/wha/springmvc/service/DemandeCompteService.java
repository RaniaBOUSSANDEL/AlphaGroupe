package com.wha.springmvc.service;

import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.Demande;
import com.wha.springmvc.model.DemandeOuvertureCompte;


public interface DemandeCompteService {
	
	
	DemandeOuvertureCompte createDemandeCompte();             /* Créer une demande*/
//	void deleteDemandeById(int id);                           /* Suprimer une demande*/
	DemandeOuvertureCompte findById(int id);                                     /* Chercher une demande par son Id*/
//	List<Demande> findByEtatDemande(String etatDemande);     /* Chercher des demande par etat*/
//	List<Demande> findByDateDemande(Date date);                     /* Chercher des demande par date*/
//	void updateDemande(Demande demande);                             /* MAJ d'une demande*/
//	public boolean isDemandeExist(Demande demande);           /* vérifier si la demande exist sur notre base*/
	List<DemandeOuvertureCompte> findAllDemandes();                                         /*afficher tt les demande*/
	DemandeOuvertureCompte affecterDemande(int id_demandeCompte, int id_cons);    /* consiste à donner a la demande l'id du conseiller qui va traiter la demande*/
//	List<DemandeOuvertureCompte> findByAffectation(String etatAffectation);  /*chercher des demande par etat d'affectation*/

	

}