package com.wha.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.DemandeOuvertureCompteDao;
import com.wha.springmvc.dao.VisiteurDao;
import com.wha.springmvc.model.DemandeOuvertureCompte;
import com.wha.springmvc.model.Visiteur;


@Service("visiteurService")
@Transactional
public class VisiteurServiceImpl implements VisiteurService {
	
	@Autowired
	private VisiteurDao dao;
//	@Autowired
//	private DemandeOuvertureCompteDao demandeOCDao;
	@Autowired
	private DemandeCompteService demandeOCService;


	@Override
	/* Créer un visiteur*/
	public Visiteur createVisiteur(Visiteur visiteur) {
		//DemandeOuvertureCompte demande= (DemandeOuvertureCompte) demandeOCDao.findById(demandeOuvertureCompte_id);
		DemandeOuvertureCompte demande= demandeOCService.createDemandeCompte();
	
		visiteur.setDemandeOuvertureCompte(demande);
		System.out.println(visiteur.toString());
		dao.save(visiteur);
		return visiteur;
		
	}

	@Override
	/* Suprimer un visiteur*/
	public void deleteVisiteurById(int id) {
		dao.deleteVisiteurById(id);

	}

	@Override
	/* Chercher un visiteur par son Id*/
	public Visiteur findById(int id) {
		return dao.findById(id);
	}

	@Override
	/* Chercher un visiteur par son nom*/
	public Visiteur findByNom(String nom) {
		return dao.findByName(nom);
	}

	@Override
	/* MAJ d'un visiteur*/
	public Visiteur updateVisiteur(Visiteur visiteur) {
		Visiteur v= dao.findById( visiteur.getId());
		if (v != null) {
			v.setAdresse(visiteur.getAdresse());
			v.setEmail(visiteur.getEmail());
			v.setNumTel(visiteur.getNumTel());
			v.setNbEnfants(visiteur.getNbEnfants());
			v.setNumTel(visiteur.getNumTel());
		
		}
		dao.save(v);
		return v;
	}
	public Visiteur isVisiteurExist(Visiteur visiteur) {
		return findByNom(visiteur.getNom()) ;
	}

	@Override
	/*afficher tt les visiteurs*/
	public List<Visiteur> findAllVisiteurs() {
		return dao.findAllVisiteurs();
		
	}

}